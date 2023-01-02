package citizenmanagementplatformTest;

import citizenmanagementplataform.UnifiedPlatform;
import data.Nif;
import data.SmallCode;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UnifiedPlatformTest {

    private UnifiedPlatform up;
    private Date date;

    @BeforeEach
    public void setUp() throws IncorrectStateException {
        up = new UnifiedPlatform();
        date = up.user.getValDate();
        up.selectJusMin();
        up.selectProcedures();
        up.selectCriminalReportCertf();
    }

    @Test
    public void enterNIFandPINobtNullNifTest() throws IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NullAtr, IncorrectStateException {
        try {
            up.enterNIFandPINobt(null, date);
        } catch (NifNotRegisteredException e) {
            System.out.println(e);
        }
    }

    @Test
    public void enterNIFandPINobtNullValdateTest() throws NifNotRegisteredException, AnyMobileRegisteredException, ConnectException, NullAtr, IncorrectStateException {
        try {
            Nif nif = new Nif("12345678A");
            up.enterNIFandPINobt(nif, null);
        } catch (IncorrectValDateException e) {
            System.out.println(e);
        }
    }

    @Test
    public void enterNIFandPINobtTest() throws IncorrectValDateException, ConnectException, NullAtr, IncorrectStateException, NifNotRegisteredException, AnyMobileRegisteredException {
        up.selectAuthMethod((byte) 1);
        up.enterNIFandPINobt(new Nif(""), date);
    }

    @Test
    public void enterPINNullPINTest() throws ConnectException, NullAtr {
        try {
            up.enterPIN(null);
        } catch (NotValidPINException e) {
            System.out.println(e);
        }
    }

    @Test
    public void enterPINTest() throws NotValidPINException, ConnectException, NullAtr {
        up.enterPIN(new SmallCode(""));
        try{
            up.enterPIN(new SmallCode("132"));
        } catch (NotValidPINException e){
            System.out.println(e);
        }
    }
}
