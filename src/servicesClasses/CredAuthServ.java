package servicesClasses;

import exceptions.ConnectException;
import exceptions.InsufficientBalanceException;
import exceptions.NotValidPaymentDataException;
import exceptions.NullAtr;
import publicadministration.CardPayment;
import publicadministration.Citizen;
import publicadministration.CreditCard;
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
        } else {
            CardPayment payment = new CardPayment(nTrans, citizen.getNif(), date, imp);
            cardData.setBalance(payment.getImport());
            System.out.println("[I] Transferència realitzada en èxit.");
        }
        return true;
    }
}
