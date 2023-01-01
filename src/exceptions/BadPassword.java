package exceptions;

public class BadPassword extends Exception{
    public BadPassword() {
        super("La contrasenya ha de tindre més de 4 caràcters");
    }
}
