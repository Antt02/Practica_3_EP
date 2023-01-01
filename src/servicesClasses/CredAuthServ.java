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
    //potser cal algun setter?
    Citizen citizen;

    public CredAuthServ(Citizen citizen){this.citizen = citizen;}
    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException, NullAtr {
        if(!cardData.getNif().equals(citizen.getNif())){
            throw new NotValidPaymentDataException();
        }
        //no se com checkejar el balance, ja que només tenim aquest atribut a CardPayment
        //podem afegir-lo a CreditCard? ns
        //parla d'un compte associat a la tarjeta, potser si que ho hem de fer pero ns
        //si podeu preguntar-ho per disc o algo tysm
        CardPayment payment = new CardPayment(nTrans, citizen.getNif(), date, imp);
        //reduim el balance del compte del ciutadà segons imp? setter o algo ns?
        return true;
    }
}
