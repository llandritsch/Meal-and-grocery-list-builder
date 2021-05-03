package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Recipes.
 */

@Entity(name = "Recipes")
@Table(name = "Recipes")
public class Recipes {

    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "recipe_name")
    private String recipe_name;

    @Column(name = "public_recipe")
    private int public_recipe;

    @Column(name = "Users_id")
    private int userId;

    @Column(name = "instructions")
    private String instructions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Users_id")
    @Transient
    private Users user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Recipes_recipe_id")
    private Set<Ingredients> ingredients;

    /**
     * Instantiates a new Recipes.
     */
    public Recipes() {

    }

    /**
     * Instantiates a new Recipes.
     *
     * @param recipe_name   the recipe name
     * @param public_recipe the public recipe
     * @param user          the user
     */
    public Recipes(String recipe_name, int public_recipe, Users user, Set<Ingredients> ingredients, String instructions) {
        this.user = user;
        this.recipe_name = recipe_name;
        this.public_recipe = public_recipe;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public int getUserId() {
        return this.userId;
    }

    /**
     * Gets recipe id.
     *
     * @return the recipe id
     */
    public int getRecipe_id() {
        return id;
    }

    /**
     * Sets recipe id.
     *
     * @param recipe_id the recipe id
     */
    public void setRecipe_id(int recipe_id) {
        this.id = recipe_id;
    }

    /**
     * Gets recipe name.
     *
     * @return the recipe name
     */
    public String getRecipe_name() {
        return recipe_name;
    }

    /**
     * Sets recipe name.
     *
     * @param recipe_name the recipe name
     */
    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    /**
     *  gets instructions
     * @return
     */
    public String getInstructions() {return instructions;}

    /**
     * sets instructions
     * @param instructions
     */
    public void setInstructions(String instructions) {this.instructions = instructions;}

    /**
     * Gets public recipe.
     *
     * @return the public recipe
     */
    public int getPublic_recipe() {
        return public_recipe;
    }

    /**
     * Sets public recipe.
     *
     * @param public_recipe the public recipe
     */
    public void setPublic_recipe(int public_recipe) {
        this.public_recipe = public_recipe;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(Users user) {
        this.user = user;
    }

    public Set<Ingredients> getIngredients() {return ingredients;}

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "recipe_id=" + id +
                ", recipe_name='" + recipe_name + '\'' +
                ", public_recipe=" + public_recipe +
                ", user=" + user +
                '}';
    }
}
