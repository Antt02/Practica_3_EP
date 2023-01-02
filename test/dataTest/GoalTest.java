package dataTest;

import data.*;
import exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static data.goalTypes.*;


public class GoalTest {
    @Test
    public void NullGoal() {
        Goal goal = new Goal(null);
        try {
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
