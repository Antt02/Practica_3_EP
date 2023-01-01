package exceptions;

public class BadGoal extends Exception {
    public BadGoal() {
        super("La opció passada com a paràmetre no es correcta.");
    }
}
