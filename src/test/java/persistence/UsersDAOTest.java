package persistence;

import entity.Users;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersDAOTest {


    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        UsersDAO usersDAO = new UsersDAO();
        List<Users> users = usersDAO.getAllUsers();
        assertEquals(1, users.size());
    }

    @Test
    void createUser() {
    }
}