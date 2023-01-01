package exceptions;

public class BadNif extends Exception {
    public BadNif() {
        super("El nif passat com a paràmetre no es correcte.");
    }
}
