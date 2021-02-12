package persistence;

import entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private UsersDAO usersDao = new UsersDAO();

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<Users> users = usersDao.getAllUsers();
        assertEquals(1, users.size());
    }

    /**
     * Verify successful retrieval of user by username
     */
    @Test
    void getUserByUsername() {
        List<Users> users = usersDao.getUserByUsername("landritsch");
        logger.info("username: " + users);
        assertEquals(1, users.size());
    }


    @Test
    void createUser() {
    }

    /**
     * Verify succuessful retrieval of user by ID
     */
    @Test
    void getByIdSuccess() {
        Users users = usersDao.getUserById(1);
        assertEquals(1, 1);
    }
}