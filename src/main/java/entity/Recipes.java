package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Recipes")
@Table(name = "Recipes")
public class Recipes {

    private int recipe_id;
    private String recipe_name;
    private int public_recipe;
    private Users user;

    public Recipes() {

    }

    public Recipes(String recipe_name, int public_recipe, Users user) {
        this.user = user;
        this.recipe_name = recipe_name;
        this.public_recipe = public_recipe;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public int getPublic_recipe() {
        return public_recipe;
    }

    public void setPublic_recipe(int public_recipe) {
        this.public_recipe = public_recipe;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "recipe_id=" + recipe_id +
                ", recipe_name='" + recipe_name + '\'' +
                ", public_recipe=" + public_recipe +
                ", user=" + user +
                '}';
    }
}
