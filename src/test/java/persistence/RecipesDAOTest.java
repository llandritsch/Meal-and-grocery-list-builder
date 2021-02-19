package persistence;

import entity.Recipes;
import entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipesDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private RecipesDAO recipesDao = new RecipesDAO();
    private UsersDAO usersDao = new UsersDAO();
    int testUserId = 0;
    int testRecipeId = 0;

    /**
     * Create a test user for tests to access if/when needed
     */
    @BeforeEach
    void setUp() {
        test.util.Database database = test.util.Database.getInstance();
        //database.runSQL("cleandb.sql");
        Users newUser = new Users();
        newUser.setUserName("Lucy");
        newUser.setPassword("bananas");
        testUserId = usersDao.createUser((newUser));
        Recipes newRecipe = new Recipes();
        newRecipe.setRecipe_name("Chicken Tikka Masala");
        newRecipe.setPublic_recipe(1);
        testRecipeId = recipesDao.createRecipe((newRecipe));
        logger.info("RECIPE ID" + testRecipeId);
    }

    @Test
    void getAllRecipes() {
    }

    @Test
    void getRecipeByName() {
    }

    @Test
    void getRecipeById() {
    }

    @Test
    void createRecipe() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void deleteReipc() {
    }
}