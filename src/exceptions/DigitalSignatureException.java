package exceptions;

public class DigitalSignatureException extends Exception {
    public DigitalSignatureException() {
        super("La signatura digital passada com a paràmetre no està formada correctament o es null.");
    }
}
