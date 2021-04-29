import { Component, OnInit } from '@angular/core';
import {Recipe, RecipeIngredient} from "../services/recipes.service";
import {NgForm} from "@angular/forms";
import {MatGridListModule} from '@angular/material/grid-list';

type RecipeData = Recipe;
type IngredientData = RecipeIngredient

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {
  recipe: Recipe = {};
  ingredients: RecipeIngredient[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  saveRecipe(form: NgForm) {
    const recipeData: RecipeData = form.value;
    const recipeToSave: Recipe = {
      recipe_name: recipeData.recipe_name,
    }
    console.log("Saving Recipe" + recipeToSave);
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
    console.log(ingredientData);
    console.log(ingredientToAdd);
    this.ingredients.push(ingredientToAdd);
  }
  // addIngredientToIngredientArray(
  //   ingredientName: string,
  //   ingredientQuantity: number,
  //   measurementType: string,
  //   grocerySection: string
  // ) {
  //   this.ingredients.push({
  //     ingredientQuantity,
  //     ingredientName,
  //     measurementType,
  //     grocerySection
  //   });
  // }
}
