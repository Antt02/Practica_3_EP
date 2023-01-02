package servicesClasses;

import data.Goal;
import exceptions.ConnectException;
import exceptions.IncorrectVerificationException;
import publicadministration.Citizen;
import services.GPD;

public class GenPolDep implements GPD {
    //potser cal algun setter?
    Citizen citizen;

    public GenPolDep(Citizen citizen){this.citizen = citizen;}
    @Override
    public boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException {
        if(!persData.equals(citizen) || !goal.checkGoal()){
            throw new IncorrectVerificationException();
        }
        System.out.println("[I] Procedimiento registrado");
        return true;
    }
}
