package publicadministration;

import data.DocPath;
import exceptions.BadPathException;
import exceptions.NullAtr;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class PDFDocument {

    private Date creatDate;
    private DocPath path;
    private File file;
    private final static String defaultPath = "informe.pdf";

    // Q: PDF DOCUMENT NO HAURIA DE TENIR UN Path com a parametre a la constructora?
    public PDFDocument() throws NullAtr, BadPathException {
        this.creatDate = new Date();
        this.path = new DocPath(defaultPath);
        this.file = new File(path.getDocPath());
    }

    public DocPath getPath() {
        return this.path;
    }

    public File getFile() {
        return this.file;
    }

    @Override
    public String toString() {
        return "PDFDocument{" +
                "creatDate=" + creatDate.toString() +
                ", path=" + path.toString() +
                '}';
    }

    public void moveDoc(DocPath destPath) throws IOException, NullAtr, BadPathException {
        if (destPath == null) throw new NullPointerException("Path no pot ser null");
        path = new DocPath(destPath.getDocPath());
        file = new File(destPath.getDocPath());

    }

    public void openDoc(DocPath path) throws NullAtr, BadPathException {
        try {
            File file = new File(path.getDocPath());
            String abspath = file.getAbsolutePath();
            Desktop.getDesktop().open(new File(abspath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
