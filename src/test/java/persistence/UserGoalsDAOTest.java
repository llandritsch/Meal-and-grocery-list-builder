package persistence;

import entity.UserGoals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserGoalsDAOTest {

    @BeforeEach
    void setUp() {
    }

    UserGoalsDAO dao = new UserGoalsDAO();

    @Test
    void getUserGoals() {
        List<UserGoals> goals = dao.getUserGoals();
        assertEquals(true, goals.size() > 0);
    }

    /**
     * Verify successful retrieval of user by userid
     */
    @Test
    void getUserGoalsByUserid() {
        List<UserGoals> goals = dao.getGoalsByUserid(391);
        assertEquals(1, dao.getUserGoals().size());
    }

    //    @Test
//    void createRecipe() {
//        int numberOfRecipes = recipesDao.getAllRecipes().size();
//        Recipes newRecipe = new Recipes();
//        newRecipe.setRecipe_name("Chicken Street Tacos");
//        newRecipe.setPublic_recipe(1);
//        newRecipe.setUser(testUser);
//        recipesDao.createRecipe(newRecipe);
//        assertEquals(numberOfRecipes + 1, recipesDao.getAllRecipes().size());
//    }


}