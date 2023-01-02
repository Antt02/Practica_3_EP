package publicadministration;

import data.Nif;
import exceptions.*;

import java.math.BigDecimal;
import java.util.Date;

public class CardPayment {

    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal imp; // The import of the payment

    public CardPayment(String ref, Nif nif, Date date, BigDecimal imp) {
        this.reference = ref;
        this.nif = nif;
        this.date = date;
        this.imp = imp;
    }

    public String getReference() {
        return this.reference;
    }

    public Nif getNif() {
        return this.nif;
    }

    public Date getData() {
        return this.date;
    }

    public BigDecimal getImport() {
        return this.imp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardPayment cp = (CardPayment) o;
        return nif.equals(cp.nif) && reference.equals(cp.reference) && date.equals(cp.date) && imp.equals(cp.imp);
    }
    @Override
    public String toString() {
        try {
            return "CardPayment{" +
                    "reference=" + this.reference +
                    ", nif='" + this.nif.getNif() +
                    ", date=" + this.date +
                    ", import=" + this.imp +
                    "}";
        } catch (NullAtr | BadNif e) {
            throw new RuntimeException(e);
        }
    } // converts to String
}
