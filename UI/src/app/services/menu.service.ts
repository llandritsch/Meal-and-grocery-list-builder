import { Injectable } from '@angular/core';
import { Recipe } from "./recipes.service";

type RecipesState = {
  [key: string]: Recipe
}

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor() {}

  // Recipes that have been added to the menu
  private recipes: RecipesState = {};

  getMenu(): Recipe[] {
    return Object.values(this.recipes);
  }

  addToMenu(recipe: Recipe): void {
    this.recipes[recipe.recipe_id] = recipe;
  }

  removeFromMenu(recipe: Recipe): void {
    delete this.recipes[recipe.recipe_id];
  }

  checkForRecipe(recipe): boolean {
    return recipe.recipe_id in this.recipes;
  }

}

