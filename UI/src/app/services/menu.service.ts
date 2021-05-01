import { Injectable } from '@angular/core';
import { Recipe } from "./recipes.service";
import {ApiService} from "./api.service";

export type Menu = {
  id: number;
  userId: number;
  recipes: Recipe[]
}

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private apiService: ApiService) {}

  private baseUrl = "/api/MenuService/menu"

  async getMenu(): Promise<Menu> {
    return await this.apiService.get<Menu>(this.baseUrl).toPromise();
  }

  addToMenu(recipe: Recipe): void {
    //this.recipes[recipe.recipe_id] = recipe;
  }

  removeFromMenu(recipe: Recipe): void {
    //delete this.recipes[recipe.recipe_id];
  }

  checkForRecipe(recipe): boolean {
    return false;
    //return recipe.recipe_id in this.recipes;
  }

}

