package exceptions;

public class NotValidPINException extends Exception {
    public NotValidPINException() {
        super("El Pin passat com a paràmetre no es correcte.");
    }
}
