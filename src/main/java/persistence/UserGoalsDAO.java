package persistence;

import entity.UserGoals;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

public class UserGoalsDAO {

    private final Logger logger = (Logger) LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<UserGoals> getUserGoals() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(UserGoals.class);
        Root<UserGoals> root = query.from(UserGoals.class);
        List<UserGoals> goals = session.createQuery(query).getResultList();
        session.close();
        return goals;
    }

}
