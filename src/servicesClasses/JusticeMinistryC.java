package servicesClasses;

import data.DigitalSignature;
import data.Goal;
import exceptions.*;
import publicadministration.Citizen;
import publicadministration.CrimConviction;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;
import services.JusticeMinistry;
import java.util.Date;
import java.util.Map;

public class JusticeMinistryC implements JusticeMinistry {
    //potser cal algun setter?
    Citizen citizen;
    public JusticeMinistryC(Citizen citizen){this.citizen = citizen;}
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException, BadNif, NullAtr, BadPathException {
        if(!persD.getNif().equals(citizen.getNif())){
            throw new BadNif();
        }
        DigitalSignature ds = new DigitalSignature(citizen.getDigSign().getDigitalsignature());
        CrimConvictionsColl coll = new CrimConvictionsColl(citizen);
        /*BORRAR COMENTARI ABANS DE FER COMMIT
        sempre tindrem ciutadans sense crims? potser
        l'Oriol fa algo semblant i te un 11? també, so...
        */
        return new CriminalRecordCertf(citizen.getNif(), citizen.getName(), g, ds, coll);
    }
}
