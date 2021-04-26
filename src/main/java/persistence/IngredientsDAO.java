package persistence;


import entity.Ingredients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
}