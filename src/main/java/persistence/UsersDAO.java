package persistence;

import entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UsersDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * Creates the proper sql statement for search and sends the sql statement to be executed
     * @return users
     */
    public List<Users> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        List<Users> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * gets user by username
     * @param username
     * @return users
     */
    public List<Users> getUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        Expression<String> propertyPath = root.get("username");
        query.where(builder.like(propertyPath, "%" + username + "%"));
        List<Users> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * gets user by Id
     * @param userId
     * @return users
     */
    public Users getUserById(int userId) {
        Session session = sessionFactory.openSession();
        Users users = session.get(Users.class, userId);
        session.close();
        return users;
    }

    /**
     * creates a new user
     * @param user
     * @return id of new user
     */
    public int createUser(Users user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * updates an existing user
     * @param user
     */
    public void saveOrUpdate(Users user) {
        Session session = sessionFactory.openSession();
        logger.info("Save/Update: " + user);
        session.saveOrUpdate(user);
        session.beginTransaction().commit();
        session.close();
    }

    /**
     * deletes a user
     * @param user
     */
    public void deleteUser(Users user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    /**
     * Deletes all users
     */
    public void deleteAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from Users").executeUpdate();
        transaction.commit();
        session.close();
    }
}

