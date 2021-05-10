package persistence;

import entity.Recipes;
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
 * DAO for Recipes
 * @author lisaandritsch
 */
public class RecipesDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * Creates the proper sql statement for search and sends the sql statement to be executed
     * @return users
     */
    public List<Recipes> getAllRecipes() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipes> query = builder.createQuery(Recipes.class);
        Root<Recipes> root = query.from(Recipes.class);
        List<Recipes> recipes = session.createQuery(query).getResultList();
        session.close();
        return recipes;
    }

    /**
     * gets recipe by username
     * @param recipeName
     * @return users
     */
    public List<Recipes> getRecipeByName(String recipeName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipes> query = builder.createQuery(Recipes.class);
        Root<Recipes> root = query.from(Recipes.class);
        Expression<String> propertyPath = root.get("recipe_name");
        query.where(builder.like(propertyPath, "%" + recipeName + "%"));
        List<Recipes> recipes = session.createQuery(query).getResultList();
        session.close();
        return recipes;
    }

    /**
     * gets recipe by Id
     * @param recipeId
     * @return users
     */
    public Recipes getRecipeById(int recipeId) {
        Session session = sessionFactory.openSession();
        Recipes recipes = session.get(Recipes.class, recipeId);
        session.close();
        return recipes;
    }

    /**
     * creates a new user
     * @param recipe
     * @return id of new user
     */
    public int createRecipe(Recipes recipe) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(recipe);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * updates an existing user
     * @param recipe
     */
    public void saveOrUpdate(Recipes recipe) {
        Session session = sessionFactory.openSession();
        logger.info("Save/Update: " + recipe);
        session.saveOrUpdate(recipe);
        session.beginTransaction().commit();
        session.close();
    }

    /**
     * deletes a user
     * @param recipe
     */
    public void deleteRecipe(Recipes recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(recipe);
        transaction.commit();
        session.close();
    }

    /**
     * Deletes all recipes
     */
    public void deleteAllRecipes() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from Recipes").executeUpdate();
        transaction.commit();
        session.close();
    }
}

