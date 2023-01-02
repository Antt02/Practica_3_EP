package servicesClassesTest;

import data.*;
import exceptions.ConnectException;
import exceptions.IncorrectVerificationException;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import servicesClasses.GenPolDep;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenPolDepTest {
    @Test
    public void IncorrectParameters() throws IncorrectVerificationException, ConnectException {
        Goal g = new Goal(goalTypes.WORKWITHMINORS);
        Citizen user = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        GenPolDep polDep = new GenPolDep(user);
        //Nif incorrecte
        Citizen BadUser1 = new Citizen(new Nif("12345678B"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        //Nom incorrecte
        Citizen BadUser2 = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        //PIN incorrecte
        Citizen BadUser3 = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        assertThrows(IncorrectVerificationException.class, () -> polDep.verifyData(BadUser1, g));
        assertThrows(IncorrectVerificationException.class, () -> polDep.verifyData(BadUser2, g));
        assertThrows(IncorrectVerificationException.class, () -> polDep.verifyData(BadUser3, g));
        assertTrue(polDep.verifyData(user, g));
    }
}
