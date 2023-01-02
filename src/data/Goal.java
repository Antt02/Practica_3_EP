package data;
import exceptions.*;
public class Goal {
    private final goalTypes goal;

    public Goal (goalTypes code) { this.goal = code; }

    public goalTypes getGoal() throws NullAtr, BadGoal{
        if (goal == null){
            throw new NullAtr("La opció passada com a paràmetre no pot ser null");
        }
        //no podem tenir un goal que no estigui format per un goalType, perque per a
        //crear-lo li demanem que sigui un, amb altres té sentit comprovar-ho perque
        //depen de com estigui format el String, pero aquest no
        return goal;
    }

    public boolean checkGoal() {
        for(goalTypes gt : goalTypes.values()) {
            if (goal == gt) {
                return true;
            }
        }
        return false;
    }

    @Override
    //goal -> atribut de classe
    //goal1 -> nou objecte
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal1 = (Goal) o;
        return goal.equals(goal1.goal);
    }

    @Override
    public int hashCode () { return goal.hashCode(); }

    @Override
    public String toString () {
        return "Goal{" + "Goal ciudadano='" + goal.toString() + '\'' + '}';
    }
}