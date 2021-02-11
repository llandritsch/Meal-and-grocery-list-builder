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

    @Test
    void getUserByUsername() {
        List<Users> users = usersDao.getUserByUsername("landritsch");
        logger.info("username: " + users);
        assertEquals("landritsch", users.get(0));
    }

    @Test
    void createUser() {
    }
}