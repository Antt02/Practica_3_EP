package publicadministrationTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicadministration.CrimConviction;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class CrimConvictionTest {
    private CrimConviction crmC;
    private Date date;

    @BeforeEach
    public void setUp() {
        crmC = new CrimConviction(new Date(), "Arson", "12 years");
        date = new Date();
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
