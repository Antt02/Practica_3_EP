package dataTest;

import data.Password;
import exceptions.BadPassword;
import exceptions.NullAtr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PasswordTest {
    @Test
    public void NullPassword() {
        Password pass = new Password(null);
        try {
            assertNull(pass.getPassword());
        } catch (NullAtr | BadPassword e) {
            System.out.println(e);
        }
    }

    @Test
    public void CorrectPasword() throws NullAtr, BadPassword {
        Password pass1 = new Password("1234abc");
        String pass2 = "1234abc";
        assertEquals(pass2, pass1.getPassword());
    }

    @Test
    public void BadNif() throws BadPassword, NullAtr {
        //llargada errònia
        Password pass = new Password("");
        try {
            pass.getPassword();
        } catch (BadPassword | NullAtr e) {
            System.out.println(e);
        }
        try {
            pass = new Password("123");
            pass.getPassword();
        } catch (BadPassword | NullAtr e) {
            System.out.println(e);
        }
    }
}
