package exceptions;

public class IncorrectStateException extends Exception{
    public IncorrectStateException() {
        super("La operació no està en el estat correcte, no es pot executar.");
    }
}
