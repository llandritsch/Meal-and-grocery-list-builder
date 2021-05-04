import { Component, OnInit } from '@angular/core';
import {Recipe, RecipeIngredient, RecipesService} from "../../services/recipes.service";
import {NgForm} from "@angular/forms";
import {CdkTextareaAutosize} from '@angular/cdk/text-field';
import {NgZone, ViewChild} from '@angular/core';

type RecipeFormData = {
  recipeName: string;
  instructions: string;
}

type IngredientData = RecipeIngredient;

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {
  recipe: Recipe = {};
  ingredients: RecipeIngredient[] = [];

  constructor(
    private recipeSvc: RecipesService,
    private _ngZone: NgZone
  ) {}


  ngOnInit(): void {
  }

  async saveRecipe(form: NgForm) {
    const recipeData: RecipeFormData = form.value;
    if (recipeData.recipeName != null && recipeData.instructions != null && this.ingredients.length > 0) {
      const recipeToSave: Recipe = {
        recipe_name: recipeData.recipeName,
        instructions: recipeData.instructions,
      }
      // Create the recipe
      const recipe = await this.recipeSvc.create(recipeToSave);
      // Add ingredients to it
      await this.recipeSvc.addIngredients(recipe, this.ingredients);
      // Reset Form
      form.resetForm();
    } else {
      alert("Please add Recipe name, instructions, and at least one ingredient before saving recipe");
    }
  }

  addIngredientToIngredientArray(form: NgForm) {
    const ingredientData: IngredientData = form.value;
    const ingredientToAdd: RecipeIngredient = {
      ingredientName: ingredientData.ingredientName,
      ingredientQuantity: ingredientData.ingredientQuantity,
      measurementType: ingredientData.measurementType,
      grocerySection: ingredientData.grocerySection,
      protein: ingredientData.protein,
      carbs: ingredientData.carbs,
      fat: ingredientData.fat
    }
    this.ingredients.push(ingredientToAdd);
    form.resetForm();
  }

  @ViewChild('autosize') autosize: CdkTextareaAutosize;


}
