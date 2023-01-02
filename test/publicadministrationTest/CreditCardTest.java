package publicadministrationTest;

import data.Nif;
import data.SmallCode;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CreditCard;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    private CreditCard cc;

    @BeforeEach
    public void setUp(){
        cc = new CreditCard(new Nif("12345678A"), "1234567814325674", new Date(), new SmallCode("123"));
    }

    @Test
    public void sameNif(){
        try {
            assertEquals(new Nif("12345678A"), cc.getNif());
            assertEquals("12345678A", cc.getNif().getNif());
        } catch (NullAtr | BadNif e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sameCsv(){
        SmallCode csv = new SmallCode("123");
        assertEquals(csv, cc.getSvc());
        try {
            assertEquals(csv.getSmallCode(), cc.getSvc().getSmallCode());
        } catch (NullAtr | BadSmallCode e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
