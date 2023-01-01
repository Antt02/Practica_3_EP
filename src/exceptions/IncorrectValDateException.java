package exceptions;

public class IncorrectValDateException extends Exception {
    public IncorrectValDateException() {
        super("La data de validació i el nif no corresponen");
    }
}
