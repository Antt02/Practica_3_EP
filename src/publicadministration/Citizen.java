package publicadministration;

import data.DigitalSignature;
import data.Nif;
import data.SmallCode;
import exceptions.BadNif;
import exceptions.NullAtr;

import java.util.Date;

public class Citizen {

    private Nif nif;
    private String name;
    private String address;
    private String mobileNumb;

    //afegits durant UnifiedPlatform
    private Date valDate;
    private SmallCode pin;
    private DigitalSignature digSign;

    private CreditCard card;

    public Citizen(Nif nif, String name, String add, String mobile, Date vDate, SmallCode PIN, DigitalSignature DS) {
        this.nif = nif;
        this.name = name;
        this.address = add;
        this.mobileNumb = mobile;
        this.valDate = vDate;
        this.pin = PIN;
        this.digSign = DS;
        //this.card = card;
    }

    public Nif getNif() throws NullAtr {
        if (this.nif == null) throw new NullAtr("El Citizen te el nif null");
        return this.nif;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getMobileNumb() {
        return this.mobileNumb;
    }

    public Date getValDate() {
        return this.valDate;
    }

    public SmallCode getPIN() {
        return this.pin;
    }

    public DigitalSignature getDigSign() {
        return this.digSign;
    }

    public CreditCard getCard() {
        return this.card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
    public void setNif(Nif nif){
        this.nif = nif;
    }
    public void setValDate(Date valDate){
        this.valDate = valDate;
    }
    public void setPin(SmallCode pin){
        this.pin = pin;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen civ = (Citizen) o;
        return nif.equals(civ.nif) && name.equals(civ.name) && mobileNumb.equals(civ.mobileNumb) && address.equals(civ.address) && valDate.equals(civ.valDate) && pin.equals(civ.pin) && digSign.equals(civ.digSign);
    }

    public String toString() {
        try {
            return "Citizen{" +
                    "nif=" + this.nif.getNif() +
                    ", name=" + this.name +
                    ", address=" + this.address +
                    ", mobileNumb=" + this.mobileNumb +
                    ", valDate=" + this.valDate +
                    ", PIN=" + this.pin + "}";
        } catch (NullAtr | BadNif e) {
            throw new RuntimeException(e);
        }
    }// converts to String
}
