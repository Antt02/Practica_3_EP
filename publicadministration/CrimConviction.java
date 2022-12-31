package publicadministration;

import data.Nif;
import data.SmallCode;

import java.util.Date;

public class CrimConviction {

    private Date commitDate;
    private String offense;
    private String sentence;

    public CrimConviction (Date commit, String off, String sentc){
        this.commitDate = commit;
        this.offense = off;
        this.sentence = sentc;
    }
    public Date getCommitDate() {
        return this.commitDate;
    }

    public String getOffense() {
        return this.offense;
    }

    public String getSentence() {
        return this.sentence;
    }

    public String toString () {
        return "CrimConviction{" +
            "commitDate=" + this.commitDate +
            ", offense='" + this.offense +
            ", sentence=" + this.sentence + "}";
    } // converts to String

}
