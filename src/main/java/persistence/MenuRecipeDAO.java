package persistence;

import entity.MenuRecipe;
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

public class MenuRecipeDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Creates a new MenuRecipe
     * @param menuId
     * @param recipeId
     * @return id of new menu
     */
    public MenuRecipe create(int menuId, int recipeId) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        MenuRecipe menuRecipe = new MenuRecipe(menuId, recipeId);
        id = (int) session.save(menuRecipe);
        menuRecipe.setId(id);
        transaction.commit();
        session.close();
        return menuRecipe;
    }

    public MenuRecipe getByMenuAndRecipeId(int menuId, int recipeId) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuRecipe> query = builder.createQuery(MenuRecipe.class);
        Root<MenuRecipe> root = query.from(MenuRecipe.class);
        Expression<Integer> menuIdProp = root.get("menuId");
        Expression<Integer> recipeIdProp = root.get("recipeId");
        query.where(builder.equal(menuIdProp,  menuId));
        query.where(builder.equal(recipeIdProp,  recipeId));
        List<MenuRecipe> menuRecipes = session.createQuery(query).getResultList();
        session.close();
        if (menuRecipes.size() == 0) {
            return null;
        }
        return menuRecipes.get(0);
    }

    /**
     * deletes a MenuRecipe
     * @param menuRecipe
     */
    public void delete(MenuRecipe menuRecipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(menuRecipe);
        transaction.commit();
        session.close();
    }

}

