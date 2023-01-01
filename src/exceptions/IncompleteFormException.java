package exceptions;

public class IncompleteFormException extends Exception{
    public IncompleteFormException(){
        super("Queden camps del formulari que emplenar.");
    }
}
