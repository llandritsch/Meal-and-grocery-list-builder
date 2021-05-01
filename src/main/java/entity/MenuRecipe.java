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

    public MenuRecipe() {}

    public MenuRecipe(int menuId, int recipeId) {
        this.menuId = menuId;
        this.recipeId = recipeId;
    }

    public MenuRecipe(int id, int menuId, int recipeId) {
        this.id = id;
        this.menuId = menuId;
        this.recipeId = recipeId;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public int getMenuId() { return this.menuId; }
    public void setMenuId(int id) { this.menuId = id; }

    public int getRecipeId() { return this.recipeId; }
    public void setRecipeId(int id) { this.recipeId = id; }
}
