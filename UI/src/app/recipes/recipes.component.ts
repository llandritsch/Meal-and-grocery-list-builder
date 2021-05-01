import { Component, OnInit } from '@angular/core';
import { RecipesService, Recipe } from '../services/recipes.service';
import {Observable} from "rxjs";
import {Menu, MenuService} from "../services/menu.service";


@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {

  constructor(
    private recipeSvc: RecipesService,
    private menusService: MenuService
  ) { }

  recipes: Recipe[] = [];
  menu: Menu

  async ngOnInit(): Promise<void> {
    this.recipes = await this.recipeSvc.getRecipes();
    // Note: the view may not use "menu" at all, but we need
    // to set up data binding on this property so that the recipes
    // list refreshes any time the menu changes (as a result of
    // adding or removing recipes).
    this.menu = await this.menusService.getMenu();
  }

  async handleButtonClick(recipe: Recipe): Promise<void> {
    if (this.menusService.menuHasRecipe(recipe)) {
      await this.menusService.removeFromMenu(recipe);
    } else {
      await this.menusService.addToMenu(recipe);
    }
  }

  getButtonStyle(recipe: Recipe): string {
    if (this.menusService.menuHasRecipe(recipe)) {
      return "warn";
    }
    return "primary";
  }

  getButtonText(recipe: Recipe): string {
    if (this.menusService.menuHasRecipe(recipe)) {
      return "Remove from menu";
    }
    return "Add to menu";
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
