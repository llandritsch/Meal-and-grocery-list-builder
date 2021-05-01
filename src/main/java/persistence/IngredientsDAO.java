package persistence;


import entity.Ingredients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class IngredientsDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Ingredients> getAllIngredients() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ingredients> query = builder.createQuery(Ingredients.class);
        Root<Ingredients> root = query.from(Ingredients.class);
        List<Ingredients> ingredients = session.createQuery(query).getResultList();
        session.close();
        return ingredients;
    }

    /**
     * creates a new user
     * @param ingredient
     * @return id of new user
     */
    public int createRecipeIngredient(Ingredients ingredient) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(ingredient);
        transaction.commit();
        session.close();
        return id;
    }
}