package data;
import exceptions.DigitalSignatureException;
import java.util.Arrays;

public class DigitalSignature {
    private final byte[] digitalsignature;

    public DigitalSignature(String code) {
        //hem hagut de modificar el fet de que code no pugui ser null per a poder correr els tests
        //seria millor no fer-ho, ja que aixi evitem la possibilitat que pugui ser null
        if(code == null){
            this.digitalsignature = null;
        } else{
            this.digitalsignature = code.getBytes();
        }
    }

    public String getDigitalsignature() throws DigitalSignatureException {
        if (digitalsignature == null){
            throw new DigitalSignatureException();
        }
        return Arrays.toString(digitalsignature);
    }

    @Override
    //digitalsignature (s lowercase) -> atribut de classe
    //digitalSignature (s uppercase) -> nou objecte
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature digitalSignature = (DigitalSignature) o;
        return Arrays.equals(digitalsignature, digitalSignature.digitalsignature);
    }

    @Override
    public int hashCode () { return Arrays.hashCode(digitalsignature); }

    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano='" + Arrays.toString(digitalsignature) + '\'' + '}';
    }
}
