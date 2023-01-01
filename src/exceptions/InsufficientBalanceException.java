package exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("No hi ha suficients diners per dur a terme l'operació.");
    }
}
