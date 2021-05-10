package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Represents MenuRecipe
 * This is the associative class that bridges the many-to-many relationship
 * between a Recipe and Menu.
 * @author lisaandritsch
 */
@Entity(name = "MenuRecipe")
@Table(name = "menus_recipes")
public class MenuRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "menuId")
    private int menuId;

    @Column(name = "recipeId")
    private int recipeId;

    /**
     * instantiates menuRecipe
     */
    public MenuRecipe() {}

    /**
     * constructor with params
     * @param menuId
     * @param recipeId
     */
    public MenuRecipe(int menuId, int recipeId) {
        this.menuId = menuId;
        this.recipeId = recipeId;
    }

    /**
     * constructor with Id
     * @param id
     * @param menuId
     * @param recipeId
     */
    public MenuRecipe(int id, int menuId, int recipeId) {
        this.id = id;
        this.menuId = menuId;
        this.recipeId = recipeId;
    }

    /**
     * gets Id
     * @return Id
     */
    public int getId() { return this.id; }

    /**
     * sets Id
     * @param id
     */
    public void setId(int id) { this.id = id; }

    /**
     * gets menuId
     * @return
     */
    public int getMenuId() { return this.menuId; }

    /**
     * sets menuId
     * @param id
     */
    public void setMenuId(int id) { this.menuId = id; }

    /**
     * gets RecipeId
     * @return
     */
    public int getRecipeId() { return this.recipeId; }

    /**
     * sets recipeId
     * @param id
     */
    public void setRecipeId(int id) { this.recipeId = id; }
}
