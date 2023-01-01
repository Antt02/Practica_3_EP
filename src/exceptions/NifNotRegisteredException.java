package exceptions;

public class NifNotRegisteredException extends Exception {
    public NifNotRegisteredException() {
        super("El Nif no està registrat al sistema Cl@ve pin.");
    }
}
