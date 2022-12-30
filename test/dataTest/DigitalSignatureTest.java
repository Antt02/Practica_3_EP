package dataTest;

import data.DigitalSignature;
import exceptions.DigitalSignatureException;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class DigitalSignatureTest {
    @Test
    public void NullDigitalSignature(){
        //per a comprovar aquest test hem de modificar el constructor i fer que sempre es fiqui a null, ja que
        //el paràmetre "code" està marcat com a @NotNull. Si ho intentem, obtenim la excepció:
        //java.lang.NullPointerException: Cannot invoke "String.getBytes()" because "code" is null
        DigitalSignature digitalSignature = new DigitalSignature(null);
        try{
            assertNull(digitalSignature.getDigitalsignature());
        } catch (DigitalSignatureException e) {
            System.out.println(e);
        }
    }

    @Test
    public void CorrectDigitalSignature() throws DigitalSignatureException {
        //al fer String.getBytes() obtenim el codi ascii de cada caracter del string en un array
        DigitalSignature digitalSignature1 = new DigitalSignature("0123456789");
        String digitalSignature2 = "[48, 49, 50, 51, 52, 53, 54, 55, 56, 57]";
        assertEquals(digitalSignature2, digitalSignature1.getDigitalsignature());
    }
}
