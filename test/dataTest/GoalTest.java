package dataTest;

import data.Goal;
import data.goalTypes;
import exceptions.BadGoal;
import exceptions.NullAtr;
import org.junit.Test;

import static data.goalTypes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GoalTest {
    @Test
    public void NullGoal(){
        Goal goal = new Goal(null);
        try{
            assertNull(goal.getGoal());
        } catch (NullAtr | BadGoal e) {
            System.out.println(e);
        }
    }

    @Test
    public void CorrectGoal() throws NullAtr, BadGoal {
        goalTypes[] goals = goalTypes.values();
        Goal goal1 = new Goal(goals[0]);
        assertEquals(WORKWITHMINORS, goal1.getGoal());
    }
}
