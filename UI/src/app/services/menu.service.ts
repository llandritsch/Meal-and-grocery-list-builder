import { Injectable } from '@angular/core';
import { Recipe } from "./recipes.service";

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor() { }

  // Recipes that have been added to the menu
  recipes: Recipe[] = [];

  addToMenu(recipe: Recipe): void {
    this.recipes.push(recipe);
  }

}

