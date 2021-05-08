import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {PlatformLocation} from "@angular/common";

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

  constructor(
    private http: ApiService,
    private platformLocation: PlatformLocation
  ) {
    this.rootURL = platformLocation.getBaseHrefFromDOM() + "api/RecipeService/recipes";
  }

  private readonly rootURL;

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

