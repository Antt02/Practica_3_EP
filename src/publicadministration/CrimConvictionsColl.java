package publicadministration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CrimConvictionsColl {

    private Citizen citizen;
    private Map<Date, CrimConviction> CrimConvictions = new HashMap<Date, CrimConviction>();
    public CrimConvictionsColl(Citizen citizen){
        //Simplement no te crims
        this.citizen = citizen;
    }
    public CrimConvictionsColl (Citizen citizen, CrimConviction crimConviction){
        this.citizen = citizen;
        this.CrimConvictions = addCriminalConviction(crimConviction);
    }

    public Map<Date, CrimConviction> getCrimConvictions() {
        return this.CrimConvictions;
    }
    public Citizen getCitizen() {
        return this.citizen;
    }

    public Map<Date, CrimConviction> addCriminalConviction (CrimConviction crmC){
        Date newDate = crmC.getCommitDate();
        CrimConvictions.put(newDate, crmC);
        return CrimConvictions;
    }

    public CrimConviction getCriminalConviction (Date date){
        return CrimConvictions.get(date);
    }

    public String toString () {
        return "CrimConvictionsColl{" +
                "citizen=" + this.citizen +
                ", CrimConvictions='" + this.CrimConvictions + "}";
    }
}

