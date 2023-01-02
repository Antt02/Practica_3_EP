package citizenmanagementplataform;

import data.*;
import dummy.CertificationAuthorityDummy;
import exceptions.*;
import publicadministration.*;
import services.CertificationAuthority;
import services.GPD;

import java.util.*;

public class UnifiedPlatform {

    // PIRNTS:
    // [P] -> Cambio de pagina
    // [O] -> Operacion

    //Atributs de la classe
    Citizen user;
    State nowState;
    boolean isAuth = false;
    byte authMethod;
    private CertificationAuthorityDummy certificationAuthority;
    private GPD gpd;
    //representació de quin procés estem fent?

    //Getters

    //constructor
    public UnifiedPlatform(){
        this.user = new Citizen(new Nif(""),
                "",
                "",
                "",
                null ,
                new SmallCode(""),
                new DigitalSignature(""));
        this.nowState = State.INITIAL;
        //this.user = ???;
    }
    // Input events
    public void selectJusMin (){
        if(this.nowState != State.INITIAL){ // comprovacion que se esta en en la pagina inical

        }
        System.out.println("[P] MINISTERIO DE JUSTICA");
        this.nowState = State.IN_MIN_JUST; // cambio a la pagina de ministerio de justicia
    }

    public void selectProcedures () {
        if(this.nowState != State.IN_MIN_JUST){ // comprovacion que se esta en la pagina del ministerio de justica
            // TODO AQUI ANIRIA LA EXECPCIO DE PAGINA PERO NO SE QUINA ES
        }
        System.out.println("[P] TRAMITES");
        this.nowState = State.IN_TRAMITES; // cambio a la pagina de tramites
    }

    public void selectCriminalReportCertf () {
        if(this.nowState != State.IN_TRAMITES){
            // TODO AQUI ANIRIA LA EXECPCIO DE PAGINA PERO NO SE QUINA ES
        }
        if(!this.isAuth){
            System.out.println("[P] AUTORIZACION"); // PAGINA AUTORIZACION
            this.nowState = State.TO_AUTH;
        }
    }

    public void selectAuthMethod (byte opc) {
        System.out.println("[O] SELECCION METODO DE AUTORIZACION: "+ opc);
        this.authMethod = opc;
    }

    public void enterNIFandPINobt (Nif nif, Date valDate) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NullAtr {
        if (this.nowState != State.TO_AUTH){
            // TODO AQUI ANIRIA LA EXECPCIO DE PAGINA PERO NO SE QUINA ES
        }
        if(nif == null){
            throw new NifNotRegisteredException();
        }
        if (valDate == null){
            throw new IncorrectValDateException();
        }
        if(this.authMethod != 0) {
            if (certificationAuthority.sendPIN(nif, valDate)) {
                System.out.println("[O] ENVIADO PIN " + nif);
            } else {
                throw new ConnectException();
            }
            this.user.setNif(nif);
            System.out.println("[O] CAMBIO NIF  " + nif);
            this.user.setValDate(valDate);
            System.out.println("[O] CAMBIO VAL DATE  " + valDate);
            this.nowState = State.CURRENTLY_WORKING;
            System.out.println("[O] CAMBIO ESTADO A CURRENT WORKING");
            this.isAuth = true;
        } /*else ?{

        }*/
    }

    public void enterPIN (SmallCode pin) throws NotValidPINException, ConnectException, NullAtr {
        if(pin == null){
            throw  new NotValidPINException();
        }
        if(certificationAuthority.checkPIN(this.user.getNif(), pin)){
            System.out.println("[O] COMPROVACION PIN "+ pin);
        }
        else {
            throw new ConnectException();
        }
        System.out.println("[O] CAMBIO PIN: "+pin);
        this.user.setPin(pin);
    }

    private void enterForm (Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException, ConnectException {
        if(gpd.verifyData(citz, goal)){
            System.out.println("[O] VERIFICACION FORMULARIO ");
        }
        else{
            throw new ConnectException();
        }
    }

    private void realizePayment () {
        // TODO: NI IDEA COM FER-HO, podrien faltar metodes a CAS?
    }

    private void enterCardData (CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException{
        // TODO: DIRIA QUE FALTA FER COMPROVACIONS
        this.user.setCard(cardD);
        System.out.println("[O] CAMBI DE CARD "+cardD.toString());
    }

    private void obtainCertificate () throws BadPathException, DigitalSignatureException, ConnectException{

    }

    private void printDocument () throws BadPathException, PrintingException{

    }

    // Other internal operations (not required)
    private void registerPayment () {

    }

    private void openDocument (DocPath path) throws BadPathException, NullAtr {
        PDFDocument doc = new PDFDocument();
        doc.openDoc(path);
        System.out.println("[O]: OBRIR DOCUMENT");
    }

    private void printDocument (DocPath path) throws BadPathException, PrintingException{

    }
}
