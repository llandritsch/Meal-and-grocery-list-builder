/*

package persistence;

import entity.UserGoals;
import entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserGoalsDAOTest {
    UserGoalsDAO dao = new UserGoalsDAO();
    UsersDAO Udao = new UsersDAO();
    int testUserId;

    @BeforeEach
    void setUp() {
        Users user = new Users();
        user.setUserName("toot");
        user.setPassword("pickles");
        testUserId = Udao.createUser(user);
        UserGoals newGoal = new UserGoals();
        newGoal.setUserid(testUserId);
        newGoal.setProteinGoal(150);
        newGoal.setCarbGoal(250);
        newGoal.setFatGoal(50);
        newGoal.setUser(user);
        newGoal.setCalorieGoal(1500);
        dao.createGoals(newGoal);
    }

    @Test
    void getUserGoals() {
        List<UserGoals> goals = dao.getUserGoals();
        assertEquals(true, goals.size() > 0);
    }

    */
/**
     * Verify successful retrieval of user by userid
     *//*

    @Test
    void getUserGoalsByUserid() {
        List<UserGoals> goals = dao.getGoalsByUserid(391);
        assertEquals(1, goals.size());
    }

    */
/**
     * Verify successful creation of userGoal
     *//*

    @Test
    void createUserGoal() {
        int numberOfGoals = dao.getUserGoals().size();
        Users user = new Users();
        user.setUserName("testuser");
        user.setPassword("pickles");
        int id = Udao.createUser(user);
        UserGoals newGoal = new UserGoals();
        newGoal.setUserid(id);
        newGoal.setProteinGoal(150);
        newGoal.setCarbGoal(250);
        newGoal.setFatGoal(50);
        newGoal.setUser(user);
        newGoal.setCalorieGoal(1500);
        dao.createGoals(newGoal);
        assertEquals(numberOfGoals + 1, dao.getUserGoals().size());
    }

    @Test
    void saveOrUpdateSuccess() {
        List<UserGoals> goals = dao.getGoalsByUserid(391);
        UserGoals newGoals = goals.get(0);
        newGoals.setUserid(391);
        newGoals.setUser(Udao.getUserById(391));
        newGoals.setFatGoal(100);
        newGoals.setCalorieGoal(1200);
        dao.saveOrUpdate(newGoals);
        List<UserGoals> updatedGoals = dao.getGoalsByUserid(391);
        assertEquals(1, updatedGoals.size());
    }

    @Test
    void deleteSuccess() {
        List<UserGoals> testGoals = dao.getGoalsByUserid(testUserId);
        UserGoals goals = testGoals.get(0);
        assertEquals(true, goals != null);
        dao.deleteGoal(goals);
        List<UserGoals> deletedGoal = dao.getGoalsByUserid(testUserId);
        assertEquals(null, deletedGoal);
    }
}*/
