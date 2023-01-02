package servicesClassesTest;

import data.DigitalSignature;
import data.Nif;
import data.SmallCode;
import exceptions.ConnectException;
import exceptions.InsufficientBalanceException;
import exceptions.NotValidPaymentDataException;
import exceptions.NullAtr;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import servicesClasses.CredAuthServ;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CredAuthServTest {
    @Test
    public void UnableTo(){
        BigDecimal imp = BigDecimal.valueOf(3.86);
        Citizen user = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        CredAuthServ banc = new CredAuthServ(user);
        CreditCard card1 = new CreditCard(new Nif("12345678B"), "1234567812345678", new Date(), new SmallCode("123"));
        //fiquem el valor en negatiu per com funciona la funció valueOf
        card1.setBalance(BigDecimal.valueOf(-5));
        CreditCard card2 = new CreditCard(new Nif("12345678A"), "1234567812345678", new Date(), new SmallCode("123"));
        card2.setBalance(BigDecimal.valueOf(-3.8));
        assertThrows(NotValidPaymentDataException.class, ()-> banc.askForApproval("Trans1", card1, card1.getExpirDate(), imp));
        assertThrows(InsufficientBalanceException.class, ()-> banc.askForApproval("Trans1", card2, card2.getExpirDate(), imp));
    }

    @Test
    public void AbleTo() throws NotValidPaymentDataException, InsufficientBalanceException, NullAtr, ConnectException {
        BigDecimal imp = BigDecimal.valueOf(3.86);
        Citizen user = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        CredAuthServ banc = new CredAuthServ(user);
        CreditCard card = new CreditCard(new Nif("12345678A"), "1234567812345678", new Date(), new SmallCode("123"));
        card.setBalance(BigDecimal.valueOf(-5));
        assertTrue(banc.askForApproval("Trans1", card, card.getExpirDate(), imp));
    }
}
