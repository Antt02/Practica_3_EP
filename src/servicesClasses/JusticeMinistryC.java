package servicesClasses;

import data.*;
import exceptions.*;
import publicadministration.*;
import services.JusticeMinistry;

public class JusticeMinistryC implements JusticeMinistry {
    Citizen citizen;
    public JusticeMinistryC(Citizen citizen){this.citizen = citizen;}
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException, BadNif, NullAtr, BadPathException {
        if(!persD.getNif().equals(citizen.getNif())){
            throw new BadNif();
        }
        DigitalSignature ds = new DigitalSignature(citizen.getDigSign().getDigitalsignature());
        CrimConvictionsColl coll = new CrimConvictionsColl(citizen);
        return new CriminalRecordCertf(citizen.getNif(), citizen.getName(), g, ds, coll);
    }
}
