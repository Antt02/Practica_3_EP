package publicadministrationTest;

import data.DocPath;
import exceptions.BadPathException;
import exceptions.NullAtr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.PDFDocument;

import javax.print.Doc;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PDFDocumentTest {
    private PDFDocument doc;

    @BeforeEach
    public void createDoc() {
        try {
            doc = new PDFDocument();
        } catch (NullAtr | BadPathException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDefaultPathTest() {
        DocPath path = new DocPath("informe.pdf");
        assertEquals(path, doc.getPath());
    }

    @Test
    public void moveDocTest() throws IOException {
        DocPath nPath = new DocPath("src\\publicadministration\\informe.pdf");
        try {
            doc.moveDoc(nPath);
            assertEquals(nPath, doc.getPath());
            assertEquals(nPath.getDocPath(), doc.getFile().getPath());
        } catch (NullAtr | BadPathException e) {
            e.printStackTrace();
        }
    }
}
