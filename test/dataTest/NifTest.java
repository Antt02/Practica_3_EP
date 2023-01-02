package dataTest;

import data.Nif;
import exceptions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NifTest {
    @Test
    public void NullNif() {
        Nif nif = new Nif(null);
        try {
            assertNull(nif.getNif());
        } catch (NullAtr | BadNif e) {
            System.out.println(e);
        }
    }

    @Test
    public void CorrectNif() throws NullAtr, BadNif {
        Nif nif1 = new Nif("12345678A");
        String nif2 = "12345678A";
        assertEquals(nif2, nif1.getNif());
    }

    @Test
    public void BadNif() throws BadNif, NullAtr {
        //llargada errònia
        Nif nif1 = new Nif("");
        try {
            nif1.getNif();
        } catch (BadNif | NullAtr e) {
            System.out.println(e);
        }
        //no 8 numeros seguits
        Nif nif2 = new Nif("1234a678A");
        try {
            nif2.getNif();
        } catch (BadNif | NullAtr e) {
            System.out.println(e);
        }
        //no lletra al final
        Nif nif3 = new Nif("123456789");
        try {
            nif3.getNif();
        } catch (BadNif | NullAtr e) {
            System.out.println(e);
        }
    }
}
