import { Injectable } from '@angular/core';
import { Recipe } from "./recipes.service";
import {ApiService} from "./api.service";
import {PlatformLocation} from "@angular/common";

export type Menu = {
  id: number;
  userId: number;
  recipes: Recipe[]
}

type RecipesById = {
  [key: number]: Recipe
}

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(
    private apiService: ApiService,
    private platformLocation: PlatformLocation
  ) {
    this.baseUrl = platformLocation.getBaseHrefFromDOM() + "api/MenuService/menu"
  }

  private readonly baseUrl: string;
  private menu: Menu;
  private recipesById: RecipesById = {};

  async getMenu(): Promise<Menu> {
    await this.refreshMenu();
    return this.menu;
  }

  async addToMenu(recipe: Recipe): Promise<void> {
    await this.apiService.post(this.baseUrl + `/${recipe.recipe_id}`, null).toPromise();
    await this.refreshMenu();
  }

  async removeFromMenu(recipe: Recipe): Promise<void> {
    await this.apiService.delete(this.baseUrl + `/${recipe.recipe_id}`).toPromise();
    await this.refreshMenu();
  }

  menuHasRecipe(recipe: Recipe): boolean {
    return recipe.recipe_id in this.recipesById;
  }

  private async refreshMenu(): Promise<void> {
    const menu = await this.apiService.get<Menu>(this.baseUrl).toPromise();
    this.recipesById = {};
    menu.recipes.forEach((recipe: Recipe) => {
      this.recipesById[recipe.recipe_id] = recipe;
    });
    this.menu = menu;
  }

}

