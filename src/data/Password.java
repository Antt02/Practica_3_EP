package data;
import exceptions.*;
public class Password {
    private final String password;

    public Password (String code) { this.password = code; }

    //juntar totes les excepcions de Null en NullAtribute, i mirar si
    public String getPassword () throws NullAtr, BadPassword {
        if (password == null){
            throw new NullAtr("La password passada com a paràmetre no pot ser null");
        }
        if (checkPassword(password)){
            return password;
        } else {
            throw new BadPassword();
        }
    }

    private boolean checkPassword(String password) { return (password.length() >=4);}

    @Override
    //password -> atribut de classe
    //password1 -> nou objecte
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return password.equals(password1.password);
    }

    @Override
    public int hashCode () { return password.hashCode(); }

    @Override
    public String toString () {
        return "Password{" + "Password ciudadano='" + password + '\'' + '}';
    }
}
