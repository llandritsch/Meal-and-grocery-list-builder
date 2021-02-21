package persistence;

import entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private UsersDAO usersDao = new UsersDAO();
    int testUserId = 0;

    /**
     * Create a test user for tests to access if/when needed
     */
    @BeforeEach
    void setUp() {
        test.util.Database database = test.util.Database.getInstance();
        //database.runSQL("cleandb.sql");
        Users newUser = new Users();
        newUser.setUserName("Manji");
        newUser.setPassword("bananas");
        testUserId = usersDao.createUser((newUser));
        logger.info("USERID" + testUserId);
    }

    /**
     * Delete test user if the test method does not delete it
     */
    @AfterEach
    void cleanUp() {

        Users testUser = usersDao.getUserById(testUserId);
        if (testUser != null) {
            usersDao.deleteUser(testUser);
        }
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<Users> users = usersDao.getAllUsers();
        assertEquals(true, users.size() > 0);
    }

    /**
     * Verify successful retrieval of user by username
     */
    @Test
    void getUserByUsername() {
        List<Users> users = usersDao.getUserByUsername("Manji");
        logger.info("username: " + users);
        assertEquals(1, users.size());
    }

    /**
     * Verify user is created and added to the DB
     */
    @Test
    void createUserSuccess() {
        int numberOfUsers = usersDao.getAllUsers().size();
        Users newUser = new Users();
        newUser.setUserName("lucy");
        newUser.setPassword("bananas");
        usersDao.createUser(newUser);
        assertEquals(numberOfUsers + 1, usersDao.getAllUsers().size());

    }

    /**
     * Verify user is created and added to the DB

    @Test
    void createUserWithRecipeSuccess() {
        int numberOfUsers = 0;
        Users newUser = new Users();
        newUser.setUserName("Lucy");
        newUser.setPassword("Banananananananana");
        RecipesDAO recipeDao = new RecipesDAO();
        Recipes recipe = new Recipes("Spicy Mahi Mahi", 1, newUser);
        newUser.addRecipe(recipe);

        usersDao.createUser(newUser);
        assertEquals(numberOfUsers + 1, usersDao.getAllUsers().size());
        List<Users> testUser = usersDao.getUserByUsername("Lucy");

        assertEquals(1, recipeDao.getAllRecipes().size());

    }
    */

    /**
     * Verify succuessful retrieval of user by ID
     */
    @Test
    void getByIdSuccess() {
        Users users = usersDao.getUserById(testUserId);
        assertEquals(true, users != null);
    }

    /**
     * Verify successful deletion of user
     */
    @Test
    void deleteUserSuccess() {
        Users testUser = usersDao.getUserById(testUserId);
        assertEquals(true, testUser != null);
        usersDao.deleteUser(testUser);
        assertEquals(null, usersDao.getUserById(testUserId));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void saveOrUpdateUserSuccess() {
        Users testUser = usersDao.getUserById(testUserId);
        testUser.setUserName("The Big Lebowski");
        usersDao.saveOrUpdate(testUser);
        List<Users> updatedUser = usersDao.getUserByUsername("The Big Lebowski");
        logger.info("Test updatedUser: " + updatedUser);
        assertEquals(1, updatedUser.size());

    }
}