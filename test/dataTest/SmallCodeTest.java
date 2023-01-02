package dataTest;

import data.SmallCode;
import exceptions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmallCodeTest {
    @Test
    public void NullSmallCode() {
        SmallCode csv = new SmallCode(null);
        try {
            assertNull(csv.getSmallCode());
        } catch (NullAtr | BadSmallCode e) {
            System.out.println(e);
        }
    }

    @Test
    public void CorrectSmallCode() throws NullAtr, BadSmallCode {
        SmallCode csv1 = new SmallCode("123");
        String csv2 = "123";
        assertEquals(csv2, csv1.getSmallCode());
    }

    @Test
    public void BadNif() throws BadSmallCode, NullAtr {
        //llargada errònia
        SmallCode csv = new SmallCode("");
        try {
            csv.getSmallCode();
        } catch (BadSmallCode | NullAtr e) {
            System.out.println(e);
        }
        try {
            csv = new SmallCode("12");
            csv.getSmallCode();
        } catch (BadSmallCode | NullAtr e) {
            System.out.println(e);
        }
    }
}
