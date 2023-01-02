package publicadministrationTest;

import data.DigitalSignature;
import data.Goal;
import data.Nif;
import data.SmallCode;
import exceptions.BadPathException;
import exceptions.NullAtr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicadministration.Citizen;
import publicadministration.CrimConviction;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;

import java.util.Date;

import static data.goalTypes.WORKWITHMINORS;
import static org.junit.jupiter.api.Assertions.*;

public class CriminalRecordCertfTest {
    private CriminalRecordCertf crmRC;
    private CrimConviction crmC;
    private Citizen civ;
    private CrimConvictionsColl crmCC;
    private final Date date = new Date();

    @BeforeEach
    public void setUp() {
        crmC = new CrimConviction(date, "Arson", "12 years");
        civ = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", date, new SmallCode("123"), new DigitalSignature("0123456789"));
        crmCC = new CrimConvictionsColl(civ, crmC);
        try {
            crmRC = new CriminalRecordCertf(new Nif("12345678A"), "Juan", new Goal(WORKWITHMINORS), new DigitalSignature("0123456789"), crmCC);
        } catch (NullAtr | BadPathException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sameCriminalRecordCertf() {
        try {
            CriminalRecordCertf crmRC2 = new CriminalRecordCertf(new Nif("12345678A"), "Juan", new Goal(WORKWITHMINORS), new DigitalSignature("0123456789"), crmCC);
            assertEquals(crmRC2, crmRC);
        } catch (NullAtr | BadPathException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sameParams() {
        CrimConviction crmC2 = new CrimConviction(date, "Arson", "12 years");
        Citizen civ2 = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", date, new SmallCode("123"), new DigitalSignature("0123456789"));
        CrimConvictionsColl crmCC2 = new CrimConvictionsColl(civ2, crmC2);

        assertEquals("Juan", crmRC.getName());
        assertEquals(new Nif("12345678A"), crmRC.getNif());
        assertEquals(crmCC2, crmRC.getCrimConvs());
        assertEquals(new Goal(WORKWITHMINORS), crmRC.getGoal());
        assertEquals(new DigitalSignature("0123456789"), crmRC.getDigSign());

    }
}
