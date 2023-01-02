package publicadministration;

import data.*;
import exceptions.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CreditCard {
    //the payment information for using the card via internet
    private final Nif nif; // The nif of the user
    private final String cardNumb; // The number of the credit card
    private final Date expirDate; // The expiration date for the credit card
    private final SmallCode svc; // The Safe Verification Code
    private BigDecimal balance;
    //private Map<String, CardPayment> cardPayments;

    public CreditCard(Nif nif, String cNum, Date d, SmallCode c) {
        this.nif = nif;
        this.cardNumb = cNum;
        this.expirDate = d;
        this.svc = c;
        this.balance = BigDecimal.valueOf(0);
        //this.cardPayments = null;
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

    public BigDecimal getBalance() {
        return this.balance;
    }
    public void setBalance(BigDecimal imp) {
        this.balance = this.balance.subtract(imp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard cc = (CreditCard) o;
        return nif.equals(cc.nif) && cardNumb.equals(cc.cardNumb) && expirDate.equals(cc.expirDate) && svc.equals(cc.svc);
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
