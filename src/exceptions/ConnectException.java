package exceptions;

public class ConnectException extends Exception {
    public ConnectException() {
        super("Error de conexió.");
    }
}
