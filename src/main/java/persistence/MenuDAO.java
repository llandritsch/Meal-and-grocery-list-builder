package persistence;

import entity.Menu;
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
 * DAO for Menu
 * @author lisaandritsch
 */
public class MenuDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    // Only allowing 1 menu per user...for now

    /**
     * gets a menu by UserId
     * @param userId
     * @return menu
     */
    public Menu getByUserId(int userId) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = builder.createQuery(Menu.class);
        Root<Menu> root = query.from(Menu.class);
        Expression<Integer> propertyPath = root.get("userId");
        query.where(builder.equal(propertyPath,  userId));
        List<Menu> menus = session.createQuery(query).getResultList();
        session.close();
        if (menus.size() == 0) {
            return null;
        }
        return menus.get(0);
    }

    /**
     * creates a new menu
     * @param userId
     * @return id of new menu
     */
    public Menu create(int userId) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Menu menu = new Menu();
        menu.setUserId(userId);
        id = (int)session.save(menu);
        menu.setId(id);
        transaction.commit();
        session.close();
        return menu;
    }

    /**
     * deletes a menu
     * @param menu
     */
    public void delete(Menu menu) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(menu);
        transaction.commit();
        session.close();
    }

}

