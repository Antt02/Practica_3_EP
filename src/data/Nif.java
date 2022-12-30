package data;
import exceptions.*;

public class Nif {

    private final String nif;

    public Nif (String code) { this.nif = code; }

    public String getNif () throws NullAtr, BadNif {
        if (nif == null){
            throw new NullAtr("El Nif passat com a paràmetre no pot ser null");
        }
        if (checkNif(nif)){
            return nif;
        } else{
            throw new BadNif();
        }
    }

    private boolean checkNif(String nif) {
        //Nif correcte -> 8 nombres + 1 lletra
        //comporvem que llargada = 9
        boolean correct = (nif.length() == 9);
        //comprovem 8 nombres (si ja no es correcte no)
        for (int i = 0; i < 8 && correct; i++) {
            if (!Character.isDigit(nif.charAt(i))) {
                correct = false;
            }
        }
        //comprovem la lletra (si ja no es correcte no)
        //sense tindre en compte que sigui la lletra correcta segons el càlcul
        if (correct) {
            correct = Character.isLetter(nif.charAt(8));
        }

        return correct;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif);
    }

    @Override
    public int hashCode () { return nif.hashCode(); }

    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano='" + nif + '\'' + '}';
    }

}
