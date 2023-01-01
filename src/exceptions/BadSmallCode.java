package exceptions;

public class BadSmallCode extends Exception {
    public BadSmallCode() {
        super("El CVS passat com a paràmetre ha de contindre 3 nombres");
    }
}
