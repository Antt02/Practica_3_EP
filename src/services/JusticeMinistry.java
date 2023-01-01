package services;

import data.Goal;
import exceptions.*;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

public interface JusticeMinistry {
    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g) throws DigitalSignatureException, ConnectException, BadNif, NullAtr, BadPathException;

}
