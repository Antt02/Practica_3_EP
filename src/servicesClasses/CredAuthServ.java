package servicesClasses;

import exceptions.*;

import publicadministration.*;

import services.CAS;

import java.math.BigDecimal;
import java.util.Date;


public class CredAuthServ implements CAS {
    Citizen citizen;

    public CredAuthServ(Citizen citizen){this.citizen = citizen;}
    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException, NullAtr {
        if(!cardData.getNif().equals(citizen.getNif())){
            throw new NotValidPaymentDataException();
        }
        if (cardData.getBalance().compareTo(imp) < 0){
            throw new InsufficientBalanceException();
        }
        return true;
    }
}
