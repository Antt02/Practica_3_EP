package dataTest;

import data.DocPath;
import exceptions.BadPathException;
import exceptions.DigitalSignatureException;
import exceptions.NullAtr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DocPathTest {
    @Test
    public void NullPath(){
        DocPath docPath = new DocPath(null);
        try{
            assertNull(docPath.getDocPath());
        } catch (NullAtr | BadPathException e) {
            System.out.println(e);
        }
    }

    @Test
    public void CorrectDocPath() throws NullAtr, BadPathException {
        //al fer String.getBytes() obtenim el codi ascii de cada caracter del string en un array
        DocPath docPath1 = new DocPath("C:/User/Desktop");
        String docPath2 = "C:/User/Desktop";
        assertEquals(docPath2, docPath1.getDocPath());
    }
}
