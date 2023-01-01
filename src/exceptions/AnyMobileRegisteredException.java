package exceptions;

public class AnyMobileRegisteredException extends Exception {
    public AnyMobileRegisteredException() {
        super("El usuari no te mobil que estigui registrat");
    }
}
