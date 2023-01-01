package publicadministration;

import data.Nif;
import data.SmallCode;
import exceptions.NullAtr;
import exceptions.BadNif;
import exceptions.BadSmallCode;

import java.util.Date;


public class CreditCard {
    //the payment information for using the card via internet
    private final Nif nif; // The nif of the user
    private final String cardNumb; // The number of the credit card
    private final Date expirDate; // The expiration date for the credit card
    private final SmallCode svc; // The Safe Verification Code

    public CreditCard(Nif nif, String cNum, Date d, SmallCode c) {
        this.nif = nif;
        this.cardNumb = cNum;
        this.expirDate = d;
        this.svc = c;
    }

    public Date getExpirDate() {
        return this.expirDate;
    }

    public Nif getNif() {
        return this.nif;
    }

    public SmallCode getSvc() {
        return this.svc;
    }

    public String getCardNumb() {
        return this.cardNumb;
    }

    @Override
    //Aqui dubto del tostring
    public String toString() {
        try {
            return "CreditCard{" +
                    "nif=" + this.nif.getNif() +
                    ", cardNumb='" + this.cardNumb +
                    ", expirDate=" + this.expirDate.toString() +
                    ", svc=" + this.svc.getSmallCode() +
                    "}";
        } catch (NullAtr | BadNif | BadSmallCode e) {
            throw new RuntimeException(e);
        }
    }
    // converts to String
}