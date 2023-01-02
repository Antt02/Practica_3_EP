package publicadministrationTest;

import data.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import publicadministration.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CrimConvictionsCollTest {
    private CrimConvictionsColl crmCC;
    private Citizen civ;
    private CrimConviction crmC;
    private final Date date = new Date();

    @BeforeEach
    public void setUp(){
        crmC = new CrimConviction(date, "Arson", "12 years");
        civ = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", date, new SmallCode("123"), new DigitalSignature("0123456789"));
        crmCC = new CrimConvictionsColl(civ, crmC);
    }

    @Test
    public void sameCitizen(){
        Citizen c = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", date, new SmallCode("123"), new DigitalSignature("0123456789"));
        assertEquals(c, crmCC.getCitizen());
    }

    @Test
    public void sameCrmC(){
        Map<Date, CrimConviction> CrimConvictions = new HashMap<Date, CrimConviction>();
        CrimConviction crmC2 = new CrimConviction(date, "Arson", "12 years");
        CrimConvictions.put(date, crmC2);
        assertEquals(crmC2, crmCC.getCriminalConviction(date));
        assertEquals(CrimConvictions, crmCC.getCrimConvictions());
    }
    @Test
    public void sameCrmCC(){
        CrimConviction crmC2 = new CrimConviction(date, "Arson", "12 years");
        Citizen civ2 = new Citizen(new Nif("12345678A"), "Juan", "Carrer Lleida n1", "678888675", date, new SmallCode("123"), new DigitalSignature("0123456789"));
        CrimConvictionsColl crmCC2 = new CrimConvictionsColl(civ2, crmC2);
        assertEquals(crmCC2.getCrimConvictions(), crmCC.getCrimConvictions());
        assertEquals(crmCC2.getCitizen(), crmCC.getCitizen());
        assertEquals(crmCC2, crmCC);
    }
}
