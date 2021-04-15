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
    public List<UserGoals> getGoalsByUserid(int userid) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserGoals> query = builder.createQuery(UserGoals.class);
        Root<UserGoals> root = query.from(UserGoals.class);
        Expression<Integer> propertyPath = root.get("userid");
        query.where(builder.equal(propertyPath,  userid));
        List<UserGoals> goals = session.createQuery(query).getResultList();
        session.close();
        return goals;
    }

    public int createGoals(UserGoals userGoals) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(userGoals);
        transaction.commit();
        session.close();
        return id;
    }

}
