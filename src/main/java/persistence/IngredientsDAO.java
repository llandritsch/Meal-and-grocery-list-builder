package persistence;


import entity.Ingredients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class IngredientsDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * creates a new ingredient
     * @param recipeId
     * @param ingredient
     * @return id of new user
     */
    public int createRecipeIngredient(int recipeId, Ingredients ingredient) {
        int id = 0;
        ingredient.setRecipeId(recipeId);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(ingredient);
        transaction.commit();
        session.close();
        return id;
    }

    public void createRecipeIngredients(int recipeId, Ingredients[] ingredients) {
        for (Ingredients ingredient : ingredients) {
            this.createRecipeIngredient(recipeId, ingredient);
        }
    }
}