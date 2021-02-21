package persistence;

import entity.Recipes;
import entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipesDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private RecipesDAO recipesDao = new RecipesDAO();
    private UsersDAO usersDao = new UsersDAO();
    Users testUser;
    int testUserId = 0;
    int testRecipeId = 0;

    /**
     * Create a test user for tests to access if/when needed
     */
    @BeforeEach
    void setUp() {
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        logger.info("after clean: " + recipesDao.getAllRecipes().size());
        Users newUser = new Users();
        newUser.setUserName("Lucy");
        newUser.setPassword("bananas");
        testUserId = usersDao.createUser((newUser));
        testUser = usersDao.getUserById(testUserId);
        logger.info("after creating user: " + recipesDao.getAllRecipes().size());
        Recipes newRecipe = new Recipes();
        newRecipe.setRecipe_name("Chicken Tikka Masala");
        newRecipe.setPublic_recipe(1);
        newRecipe.setUser(testUser);
        testRecipeId = recipesDao.createRecipe((newRecipe));
        logger.info("after created recipe" + recipesDao.getAllRecipes().size());
    }

    @Test
    void getAllRecipes() {
        List<Recipes> recipes = recipesDao.getAllRecipes();
        assertEquals(true, recipes.size() > 0);
    }

    @Test
    void getRecipeByName() {
        List<Recipes> recipes = recipesDao.getRecipeByName("Chicken Tikka Masala");
        logger.info("recipe name: " + recipes);
        assertEquals(1, recipes.size());
    }

    @Test
    void getRecipeById() {
        Recipes recipes = recipesDao.getRecipeById(testRecipeId);
        assertEquals(true, recipes != null);
    }

    @Test
    void createRecipe() {
        int numberOfRecipes = recipesDao.getAllRecipes().size();
        Recipes newRecipe = new Recipes();
        newRecipe.setRecipe_name("Chicken Street Tacos");
        newRecipe.setPublic_recipe(1);
        newRecipe.setUser(testUser);
        recipesDao.createRecipe(newRecipe);
        assertEquals(numberOfRecipes + 1, recipesDao.getAllRecipes().size());
    }

    @Test
    void saveOrUpdateSuccess() {
        Recipes testRecipe = recipesDao.getRecipeById(testRecipeId);
        testRecipe.setRecipe_name("The Big Lebowski's big, scary meal");
        recipesDao.saveOrUpdate(testRecipe);
        List<Recipes> updatedRecipe = recipesDao.getRecipeByName("The Big Lebowski's big, scary meal");
        logger.info("Test updatedUser: " + updatedRecipe);
        assertEquals(1, updatedRecipe.size());
    }

    @Test
    void deleteRecipeSucess() {
        Recipes testRecipe = recipesDao.getRecipeById(testRecipeId);
        assertEquals(true, testRecipe != null);
        recipesDao.deleteRecipe(testRecipe);
        assertEquals(null, recipesDao.getRecipeById(testRecipeId));
    }
}