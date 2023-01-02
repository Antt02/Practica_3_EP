package services;

import data.Nif;
import data.SmallCode;
import exceptions.*;
import publicadministration.Citizen;

import java.util.Date;

public interface CertificationAuthority {
    Citizen citizen = null;
    Date valDate = null;
    int PIN = 0;


    // Q: AIXO RETORNA TRUE SI NO HI HA EXEPTIONS?? dummy?
    boolean sendPIN (Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NullAtr;
    boolean checkPIN (Nif nif, SmallCode pin) throws NotValidPINException, ConnectException, NullAtr;

}
