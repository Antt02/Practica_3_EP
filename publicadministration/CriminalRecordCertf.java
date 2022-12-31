package publicadministration;

import data.Goal;
import data.Nif;
import data.DigitalSignature;
import exceptions.BadPathException;
import exceptions.NullAtr;

public class CriminalRecordCertf extends PDFDocument{

    private Nif nif;
    private String name;
    private Goal goal;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;

    public CriminalRecordCertf(Nif nif, String name, Goal g, DigitalSignature ds, CrimConvictionsColl crmC) throws NullAtr, BadPathException {
        this.nif = nif;
        this.name = name;
        this.goal = g;
        this.digSign = ds;
        this.crimConvs = crmC;
    }

    public Nif getNif() {
        return this.nif;
    }

    public String getName() {
        return this.name;
    }

    public Goal getGoal() {
        return this.goal;
    }

    public DigitalSignature getDigSign() {
        return this.digSign;
    }

    public CrimConvictionsColl getCrimConvs() {
        return this.crimConvs;
    }
}