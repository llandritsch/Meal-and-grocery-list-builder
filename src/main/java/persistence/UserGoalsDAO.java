package persistence;

import entity.UserGoals;
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

/**
 * DAO for UserGoals
 * @author lisaandritsch
 */
public class UserGoalsDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Creates the proper sql statement to getAllUserGoals
     * @return
     */
    public List<UserGoals> getUserGoals() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(UserGoals.class);
        Root<UserGoals> root = query.from(UserGoals.class);
        List<UserGoals> goals = session.createQuery(query).getResultList();
        session.close();
        return goals;
    }

    /**
     * gets Goals by userid
     * @param userid
     * @return
     */
    public UserGoals getGoalsByUserid(int userid) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserGoals> query = builder.createQuery(UserGoals.class);
        Root<UserGoals> root = query.from(UserGoals.class);
        Expression<Integer> propertyPath = root.get("userid");
        query.where(builder.equal(propertyPath,  userid));
        List<UserGoals> goals = session.createQuery(query).getResultList();
        session.close();
        return goals.get(0);
    }

    /**
     * creates new userGoals
     * @param userGoals
     * @return
     */
    public int createGoals(UserGoals userGoals) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(userGoals);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * updates an existing goal
     * @param userGoals
     */
    public void saveOrUpdate(UserGoals userGoals) {
        Session session = sessionFactory.openSession();
        logger.info("Save/Update: " + userGoals);
        session.saveOrUpdate(userGoals);
        session.beginTransaction().commit();
        session.close();
    }

    /**
     * deletes goals
     * @param userGoals
     */
    public void deleteGoal(UserGoals userGoals) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userGoals);
        transaction.commit();
        session.close();
    }
}
