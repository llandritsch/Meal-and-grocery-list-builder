import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export type Recipe = {
  recipe_id?: number;
  recipe_name: string;
  ingredients: RecipeIngredient[];
}

export type RecipeIngredient = {
  id: number;
  Ingredient_Name: string;
  Recipes_recipe_id: number;
  Ingredient_Quantity: number;
  Quantity_Measurement_Type: string;
  protein: number;
  carbs: number;
  fat: number;
  grocery_section: string;
}

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  constructor(private http: HttpClient) { }

  rootURL = '/api/RecipeService';
  // Local cache of ALL recipes.
  private recipes: Recipe[] = [];

  async getRecipes(): Promise<Recipe[]> {
    if (this.recipes.length) {
      return this.recipes;
    }
    const recipes = await this.http.get<Recipe[]>(this.rootURL + "/recipes").toPromise();
    this.recipes = recipes;
    return recipes;
  }

  create(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.rootURL + "/recipes", recipe);
  }

}

