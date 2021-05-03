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

  async getRecipes(): Promise<Recipe[]> {
    return await this.http.get<Recipe[]>(this.rootURL).toPromise();
  }

  async getRecipeById(id): Promise<Recipe> {
    return await this.http.get(`${this.rootURL}/${id}`).toPromise();
  }

  create(recipe: Recipe): Promise<Recipe> {
    return this.http.post<Recipe>(this.rootURL, recipe).toPromise();
  }

  addIngredients(recipe: Recipe, ingredients: RecipeIngredient[]): Promise<Recipe> {
    const id = recipe.recipe_id;
    const payload = { ingredients };
    return this.http.post<Recipe>(`${this.rootURL}/${id}/ingredients`, payload).toPromise();
  }

  getTotalProtein(recipe: Recipe): number {
    let protein = 0;
    recipe.ingredients.forEach(ingredient => {
      protein += ingredient.protein;
    });
    return protein;
  }

  getTotalCarbs(recipe: Recipe): number {
    let carbs = 0;
    recipe.ingredients.forEach(ingredient => {
      carbs += ingredient.carbs;
    });
    return carbs;
  }

  getTotalFat(recipe: Recipe): number {
    let fat = 0;
    recipe.ingredients.forEach(ingredient => {
      fat += ingredient.fat;
    });
    return fat;
  }
}

