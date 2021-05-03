import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ApiService} from "./api.service";

export type Recipe = {
  recipe_id?: number;
  recipe_name?: string;
  Users_id?: number;
  instructions?: string;
  ingredients?: RecipeIngredient[];
}

export type RecipeIngredient = {
  id?: number;
  ingredientName?: string;
  recipesRecipeId?: number;
  ingredientQuantity?: number;
  measurementType?: string;
  protein?: number;
  carbs?: number;
  fat?: number;
  grocerySection?: string;
}

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  constructor(private http: ApiService) { }

  rootURL = '/api/RecipeService/recipes';
  // Local cache of ALL recipes.
  private recipes: Recipe[] = [];

  async getRecipes(): Promise<Recipe[]> {
    if (this.recipes.length) {
      return this.recipes;
    }
    const recipes = await this.http.get<Recipe[]>(this.rootURL).toPromise();
    this.recipes = recipes;
    return recipes;
  }

  create(recipe: Recipe): Promise<Recipe> {
    return this.http.post<Recipe>(this.rootURL, recipe).toPromise();
  }

  addIngredients(recipe: Recipe, ingredients: RecipeIngredient[]): Promise<Recipe> {
    const id = recipe.recipe_id;
    const payload = { ingredients };
    return this.http.post<Recipe>(`${this.rootURL}/${id}/ingredients`, payload).toPromise();
  }
}

