package publicadministrationTest;

import data.DigitalSignature;
import data.DocPath;
import data.Nif;
import data.SmallCode;
import exceptions.BadNif;
import exceptions.BadPathException;
import exceptions.NullAtr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.PDFDocument;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class CitizenTest {
    private Citizen civ;
    @BeforeEach
    public void setUp(){
        civ = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", new Date(), new SmallCode("123"), new DigitalSignature("0123456789"));
    }
    @Test
    public void sameNif(){
        try {
            assertEquals(new Nif("12345678A"), civ.getNif());
            assertEquals("12345678A", civ.getNif().getNif());
        } catch (NullAtr | BadNif e) {
            throw new RuntimeException(e);
        }
    }
}
