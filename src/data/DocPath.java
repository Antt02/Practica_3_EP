package data;
import exceptions.*;

public class DocPath {
    private final String docpath;

    public DocPath (String code) { this.docpath = code; }

    public String getDocPath () throws NullAtr, BadPathException{
        if (docpath == null){
            throw new NullAtr("La ruta passada com a paràmetre no pot ser null");
        }
        return docpath;

    }

    @Override
    //docpath (p lowercase) -> atribut de classe
    //docPath (p uppercase) -> nou objecte
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPath docPath = (DocPath) o;
        return docpath.equals(docPath.docpath);
    }

    @Override
    public int hashCode () { return docpath.hashCode(); }

    @Override
    public String toString () {
        return "DocPath{" + "DocPath ciudadano='" + docpath + '\'' + '}';
    }
}
