package servicesClasses;

import data.*;
import exceptions.*;
import publicadministration.Citizen;
import services.CertificationAuthority;

import java.util.Date;

public class ClavePIN implements CertificationAuthority {
    //potser cal algun setter?
    Citizen citizen;

    public ClavePIN(Citizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NullAtr {
        if (!nif.equals(citizen.getNif())){
            throw new NifNotRegisteredException();
        }
        if (!date.equals(citizen.getValDate())){
            throw new IncorrectValDateException();
        }
        if (citizen.getMobileNumb() == null){
            throw new AnyMobileRegisteredException();
        }
        return true;
    }

    @Override
    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException, NullAtr {
        if (!nif.equals(citizen.getNif()) || !pin.equals(citizen.getPIN())){
            throw new NotValidPINException();
        }
        return true;
    }
}
