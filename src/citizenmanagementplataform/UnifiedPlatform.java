package citizenmanagementplataform;

import data.*;
import exceptions.*;
import publicadministration.*;
import exceptions.*;
import java.util.*;

public class UnifiedPlatform {

    //Atributs de la classe
    Citizen user;
    State state;
    //representació de quin procés estem fent?

    //Getters

    //constructor
    public UnifiedPlatform(){
        this.state = State.INITIAL;
        //this.user = ???;
    }
    // Input events
    public void selectJusMin (){

    }

    public void selectProcedures () {

    }

    public void selectCriminalReportCertf () {

    }

    public void selectAuthMethod (byte opc) {

    }

    public void enterNIFandPINobt (Nif nif, Date valDate) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException{
        state = State.CURRENTLY_WORKING;

    }

    public void enterPIN (SmallCode pin) throws NotValidPINException, ConnectException{

    }

    private void enterForm (Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException, ConnectException {

    }

    private void realizePayment () {

    }

    private void enterCardData (CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException{

    }

    private void obtainCertificate () throws BadPathException, DigitalSignatureException, ConnectException{

    }

    private void printDocument () throws BadPathException, PrintingException{

    }

    // Other internal operations (not required)
    private void registerPayment () {

    }

    private void openDocument (DocPath path) throws BadPathException{

    }

    private void printDocument (DocPath path) throws BadPathException, PrintingException{

    }
}
