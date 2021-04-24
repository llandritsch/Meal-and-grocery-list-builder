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
}

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  constructor(private http: HttpClient) { }

  rootURL = '/api/RecipeService';

  getRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.rootURL + "recipes");
  }
  create(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.rootURL + "/recipes", recipe);
  }
}

