import { Component, OnInit } from '@angular/core';
import { RecipesService, Recipe } from '../services/recipes.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {

  constructor(private recipeSvc: RecipesService) { }

  recipes: Observable<Recipe[]> = null;

  ngOnInit(): void {
    this.recipes = this.recipeSvc.getRecipes();
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
