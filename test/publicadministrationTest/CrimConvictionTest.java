package publicadministrationTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicadministration.CrimConviction;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class CrimConvictionTest {
    private CrimConviction crmC;
    private final Date date = new Date();

    @BeforeEach
    public void setUp() {
        crmC = new CrimConviction(date, "Arson", "12 years");
    }
    @Test
    public void sameCrimConviction(){
        CrimConviction crmC2 = new CrimConviction(date, "Arson", "12 years");
        assertEquals(crmC2, crmC);
    }
    @Test
    public void sameDate() {
        assertEquals(date, crmC.getCommitDate());
    }

    @Test
    public void sameConviction() {
        assertEquals("Arson", crmC.getOffense());
        assertEquals("12 years", crmC.getSentence());
    }
}
