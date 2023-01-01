package exceptions;

public class NotValidPaymentDataException extends Exception{
    public NotValidPaymentDataException() {
        super("Dades del pagament no son correctes.");
    }
}
