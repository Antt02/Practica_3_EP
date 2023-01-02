package publicadministrationTest;

import data.Nif;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CardPayment;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CardPaymentTest {
    private CardPayment cp;

    @BeforeEach
    public void setup() {
        cp = new CardPayment("123", new Nif("12345678A"), new Date(), new BigDecimal("12345"));
    }

    @Test
    public void sameNif() {
        try {
            assertEquals(new Nif("12345678A"), cp.getNif());
            assertEquals("12345678A", cp.getNif().getNif());
        } catch (NullAtr | BadNif e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sameImp() {
        BigDecimal imp = new BigDecimal("12345");
        assertEquals(imp, cp.getImport());
        assertEquals(imp.abs(), cp.getImport().abs());
    }

}
