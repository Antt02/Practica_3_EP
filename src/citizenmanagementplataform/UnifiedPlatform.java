package citizenmanagementplataform;

import data.*;

import exceptions.*;
import publicadministration.*;
import services.*;
import servicesClasses.*;

import java.math.BigDecimal;
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
    private ClavePIN certificationAuthority;
    private CredAuthServ CAS;
    private GPD gpd;
    //representació de quin procés estem fent?

    //Getters

    //constructor
    public UnifiedPlatform() {

        this.user = new Citizen(new Nif(""),
                "",
                "",
                "",
                null,
                new SmallCode(""),
                new DigitalSignature(""));
        this.nowState = State.INITIAL;
        //this.user = ???;
    }

    // Input events
    public void selectJusMin() throws IncorrectStateException {
        if (this.nowState != State.INITIAL)
            throw new IncorrectStateException(); // comprovacion que se esta en en la pagina inical
        System.out.println("[P] MINISTERIO DE JUSTICA");
        this.nowState = State.IN_MIN_JUST; // cambio a la pagina de ministerio de justicia
    }

    public void selectProcedures() throws IncorrectStateException {
        if (this.nowState != State.IN_MIN_JUST)
            throw new IncorrectStateException(); // comprovacion que se esta en la pagina del ministerio de justica
        System.out.println("[P] TRAMITES");
        this.nowState = State.IN_TRAMITES; // cambio a la pagina de tramites
    }

    public void selectCriminalReportCertf() throws IncorrectStateException {
        if (this.nowState != State.IN_TRAMITES) throw new IncorrectStateException();
        if (!this.isAuth) {
            System.out.println("[P] AUTORIZACION"); // PAGINA AUTORIZACION
            this.nowState = State.TO_AUTH;
        }
    }

    public void selectAuthMethod(byte opc) {
        System.out.println("[O] SELECCION METODO DE AUTORIZACION: " + opc);
        this.authMethod = opc;
    }

    public void enterNIFandPINobt(Nif nif, Date valDate) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NullAtr, IncorrectStateException {
        if (this.nowState != State.TO_AUTH) throw new IncorrectStateException();
        if (nif == null) throw new NifNotRegisteredException();
        if (valDate == null) throw new IncorrectValDateException();
        if (this.authMethod != 0) {
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
        }

    }

    public void enterPIN(SmallCode pin) throws NotValidPINException, ConnectException, NullAtr {
        if (pin == null) throw new NotValidPINException();
        if (certificationAuthority.checkPIN(this.user.getNif(), pin)) {
            System.out.println("[O] COMPROVACION PIN " + pin);
        } else {
            throw new ConnectException();
        }
        System.out.println("[O] CAMBIO PIN: " + pin);
        this.user.setPin(pin);
    }

    private void enterForm(Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException, ConnectException {
        if (gpd.verifyData(citz, goal)) {
            System.out.println("[O] VERIFICACION FORMULARIO ");
        } else {
            throw new ConnectException();
        }
    }

    //aquesta funció s'utilitza al rebre el okay de la DGP
    private void realizePayment() throws IncorrectStateException {
        if (this.nowState != State.CURRENTLY_WORKING) throw new IncorrectStateException();
        System.out.println("[O] INTRODUZCA SUS DATOS"); // formulario datos de pago
    }

    private void enterCardData(CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException, NullAtr {
        if (CAS.askForApproval("Transacció 0", cardD, new Date(), BigDecimal.valueOf(-3.86))) {
            this.user.setCard(cardD);
            System.out.println("[O] DATOS CORRECTOS, PROCEDIENDO A REALIZAR LA TRANSACCIÓN");
        } else {
            throw new IncompleteFormException();
        }
    }

    private void obtainCertificate() throws BadPathException, DigitalSignatureException, ConnectException {

    }

    private void printDocument() throws BadPathException, PrintingException {
        throw new PrintingException();
    }

    // Other internal operations (not required)
    private void registerPayment() {

    }

    private void openDocument(DocPath path) throws BadPathException, NullAtr {
        PDFDocument doc = new PDFDocument();
        doc.openDoc(path);
        System.out.println("[O]: OBRIR DOCUMENT");
    }

    private void printDocument(DocPath path) throws BadPathException, PrintingException {

    }
}
