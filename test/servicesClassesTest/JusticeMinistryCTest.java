package servicesClassesTest;

import data.*;
import exceptions.*;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import servicesClasses.JusticeMinistryC;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JusticeMinistryCTest {
    @Test
    public void BadNif() throws BadNif, NullAtr, DigitalSignatureException, BadPathException, ConnectException {
        Goal g = new Goal(goalTypes.WORKWITHMINORS);
        Citizen user = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        JusticeMinistryC justice = new JusticeMinistryC(user);
        Citizen badNif = new Citizen(new Nif("12345678B"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        assertThrows(BadNif.class, () -> justice.getCriminalRecordCertf(badNif, g));
    }
}
