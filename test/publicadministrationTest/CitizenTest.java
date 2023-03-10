package publicadministrationTest;

import data.*;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CitizenTest {
    private Citizen civ;
    private final Date date = new Date();

    @BeforeEach
    public void setUp() {
        civ = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", date, new SmallCode("123"), new DigitalSignature("0123456789"));
    }

    @Test
    public void sameCitizen() {
        Citizen civ2 = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", date, new SmallCode("123"), new DigitalSignature("0123456789"));
        assertEquals(civ, civ2);
    }

    @Test
    public void sameNif() {
        try {
            assertEquals(new Nif("12345678A"), civ.getNif());
            assertEquals("12345678A", civ.getNif().getNif());
        } catch (NullAtr | BadNif e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sameCsv() {
        SmallCode csv = new SmallCode("123");
        assertEquals(csv, civ.getPIN());
        try {
            assertEquals(csv.getSmallCode(), civ.getPIN().getSmallCode());
        } catch (NullAtr | BadSmallCode e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sameDigSign() {
        DigitalSignature digitalSignature1 = new DigitalSignature("0123456789");
        String digitalSignature2 = "[48, 49, 50, 51, 52, 53, 54, 55, 56, 57]";
        assertEquals(digitalSignature1, civ.getDigSign());
        try {
            assertEquals(digitalSignature2, civ.getDigSign().getDigitalsignature());
        } catch (DigitalSignatureException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void creditCardtest() {
        civ.setCard(new CreditCard(new Nif("12345678A"), "1234567814325674", date, new SmallCode("123")));
        CreditCard cc =  new CreditCard(new Nif("12345678A"), "1234567814325674", date, new SmallCode("123"));
        assertEquals(cc, civ.getCard());
    }
}
