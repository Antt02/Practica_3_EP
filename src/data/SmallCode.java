package data;
import exceptions.*;

public class SmallCode {
    private final String smallcode;

    public SmallCode (String code) { this.smallcode = code; }

    public String getSmallCode () throws NullAtr, BadSmallCode {
        if (smallcode == null){
            throw new NullAtr("El CSV passat com a paràmetre no pot ser null");
        }
        if (checkSmallCode(smallcode)){
            return smallcode;
        } else{
            throw new BadSmallCode();
        }
    }

    private boolean checkSmallCode(String smallcode) {
        boolean correct = (smallcode.length() == 3);
        for (int i=0; i<3 && correct; i++){
            if (!Character.isDigit(smallcode.charAt(i))){
                correct = false;
            }
        }
        return correct;
    }

    @Override
    //smallcode (c lowercase) -> atribut de classe
    //smallCode (c uppercase) -> nou objecte
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCode smallCode = (SmallCode) o;
        return smallcode.equals(smallCode.smallcode);
    }

    @Override
    public int hashCode () { return smallcode.hashCode(); }

    @Override
    public String toString () {
        return "SmallCode{" + "SmallCode ciudadano='" + smallcode + '\'' + '}';
    }
}
