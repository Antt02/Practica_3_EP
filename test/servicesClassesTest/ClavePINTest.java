package servicesClassesTest;

import data.DigitalSignature;
import data.Nif;
import data.SmallCode;
import exceptions.*;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import servicesClasses.ClavePIN;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ClavePINTest {
    //comprovarem primerament, per ambdues funcions, els casos incorrectes
    //després, farem la prova de que si tot és correcte, funciona
    @Test
    public void IncorrectDataSend() {
        //primer comprovarem els errors referents al ciutadà passat com a paràmetre
        long date = 1234;
        Citizen user = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(date),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        ClavePIN clave = new ClavePIN(user);
        Citizen userBadNif = new Citizen(new Nif("12345678B"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(date),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        Citizen userBadDate = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        assertThrows(NifNotRegisteredException.class, () -> clave.sendPIN(userBadNif.getNif(), userBadNif.getValDate()));
        assertThrows(IncorrectValDateException.class, () -> clave.sendPIN(userBadDate.getNif(), userBadDate.getValDate()));

        //ara comprovarem l'excepció del telèfon mòvil
        Citizen user2 = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                null,
                new Date(date),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        ClavePIN clave2 = new ClavePIN(user2);
        assertThrows(AnyMobileRegisteredException.class, () -> clave2.sendPIN(user.getNif(), user.getValDate()));
    }

    @Test
    public void IncorrectDataCheck(){
        long date = 1234;
        Citizen user = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(date),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        ClavePIN clave = new ClavePIN(user);
        Citizen BadNif = new Citizen(new Nif("12345678B"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(date),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        Citizen BadPIN = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(date),
                new SmallCode("456"),
                new DigitalSignature("1234567890abc"));
        assertThrows(NotValidPINException.class, () -> clave.checkPIN(BadNif.getNif(), BadNif.getPIN()));
        assertThrows(NotValidPINException.class, () -> clave.checkPIN(BadPIN.getNif(), BadPIN.getPIN()));
    }

    @Test
    public void AllCorrect() throws NullAtr, IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, NotValidPINException {
        long date = 1234;
        Citizen user = new Citizen(new Nif("12345678A"),
                "Pepe",
                "C/Aleatori",
                "601020304",
                new Date(date),
                new SmallCode("123"),
                new DigitalSignature("1234567890abc"));
        ClavePIN clave = new ClavePIN(user);
        assertTrue(clave.sendPIN(user.getNif(), user.getValDate()));
        assertTrue(clave.checkPIN(user.getNif(), user.getPIN()));
    }
}
