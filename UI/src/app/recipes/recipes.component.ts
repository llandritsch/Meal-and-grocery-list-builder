import { Component, OnInit } from '@angular/core';
import { RecipesService, Recipe } from '../services/recipes.service';
import {Observable} from "rxjs";
import {MenuService} from "../services/menu.service";

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

  async ngOnInit(): Promise<void> {
    this.recipes = await this.recipeSvc.getRecipes();
  }

  handleButtonClick(recipe: Recipe): void {
    if (this.menusService.checkForRecipe(recipe)) {
      this.menusService.removeFromMenu(recipe);
    } else {
      this.menusService.addToMenu(recipe);
    }
  }

  getButtonStyle(recipe: Recipe): string {
    if (this.menusService.checkForRecipe(recipe)) {
      return "warn";
    }
    return "primary";
  }

  getButtonText(recipe: Recipe): string {
    if (this.menusService.checkForRecipe(recipe)) {
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
