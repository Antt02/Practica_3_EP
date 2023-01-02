package services;

import data.Goal;
import exceptions.*;
import publicadministration.*;


public interface JusticeMinistry {
    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g) throws DigitalSignatureException, ConnectException, BadNif, NullAtr, BadPathException;

}
