package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Ingredients.
 */
@Entity(name = "Ingredients")
@Table(name = "Recipe_Ingredients")
public class Ingredients {
    @Id
    @Column(name = "Recipes_recipe_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "Ingredient_Name")
    private String ingredientName;

    @Column(name = "Ingredient_Quantity")
    private double ingredientQuantity;

    @Column(name = "Quantity_Measurement_Type")
    private String measurementType;

    @Column(name = "grocery_section")
    private String grocerySection;

    @Column(name = "Protein")
    private double protein;

    @Column(name = "Carbs")
    private double carbs;

    @Column(name = "Fat")
    private double fat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Recipes_recipe_id")
    @Transient
    private Recipes recipe;

    /**
     * Instantiates a new Ingredients
     */
    public Ingredients() {

    }

    public Ingredients(Recipes recipe, String ingredientName, int id, double ingredientQuantity, String measurementType, double protein, double carbs, double fat, String grocerySection) {
        this.recipe = recipe;
        this.ingredientName = ingredientName;
        this.id = id;
        this.ingredientQuantity = ingredientQuantity;
        this.measurementType = measurementType;
        this.grocerySection = grocerySection;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets ingredient name.
     *
     * @return the ingredient name
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets ingredient name.
     *
     * @param ingredientName the ingredient name
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Gets ingredient quantity.
     *
     * @return the ingredient quantity
     */
    public double getIngredientQuantity() {
        return ingredientQuantity;
    }

    /**
     * Sets ingredient quantity.
     *
     * @param ingredientQuantity the ingredient quantity
     */
    public void setIngredientQuantity(double ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    /**
     * Gets measurement type.
     *
     * @return the measurement type
     */
    public String getMeasurementType() {
        return measurementType;
    }

    /**
     * Sets measurement type.
     *
     * @param measurementType the measurement type
     */
    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    /**
     * Gets grocery section.
     *
     * @return the grocery section
     */
    public String getGrocerySection() {
        return grocerySection;
    }

    /**
     * Sets grocery section.
     *
     * @param grocerySection the grocery section
     */
    public void setGrocerySection(String grocerySection) {
        this.grocerySection = grocerySection;
    }

    /**
     * Gets protein.
     *
     * @return the protein
     */
    public double getProtein() {
        return protein;
    }

    /**
     * Sets protein.
     *
     * @param protein the protein
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Gets carbs.
     *
     * @return the carbs
     */
    public double getCarbs() {
        return carbs;
    }

    /**
     * Sets carbs.
     *
     * @param carbs the carbs
     */
    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    /**
     * Gets fat.
     *
     * @return the fat
     */
    public double getFat() {
        return fat;
    }

    /**
     * Sets fat.
     *
     * @param fat the fat
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Gets recipe.
     *
     * @return the recipe
     */
    public Recipes getRecipe() {
        return recipe;
    }

    /**
     * Sets recipe.
     *
     * @param recipe the recipe
     */
    public void setRecipe(Recipes recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "recipe_id=" + id +
                ", recipe_name='" + recipe.getRecipe_name() + ' ' +
                ", ingredient name=" + ingredientName + ' ' +
                ", quantity" + ingredientQuantity + ' ' +
                ", measurement type" + measurementType +
                ", grocery section" + grocerySection +
                ", protein" + protein +
                ", carbs" + carbs +
                ", fat" + fat +
                '}';
    }

}
