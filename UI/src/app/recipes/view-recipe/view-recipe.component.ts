import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Recipe, RecipesService} from "../../services/recipes.service";


@Component({
  selector: 'app-view-recipe',
  templateUrl: './view-recipe.component.html',
  styleUrls: ['./view-recipe.component.css']
})
export class ViewRecipeComponent implements OnInit {
  id: String;
  constructor(
    private recipeSvc: RecipesService,
    private route: ActivatedRoute
  ) {
    console.log('Called Constructor');
    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
    });
  }

  recipe: Recipe;
  fat: number;
  carbs: number;
  protein: number;

  async ngOnInit(): Promise<void> {
    await this.loadRecipe(this.id);
    await this.loadMacros();
  }

  async loadRecipe(id): Promise<void> {
    this.recipe = await this.recipeSvc.getRecipeById(id);
  }

  loadMacros() {
    this.fat = this.recipeSvc.getTotalFat(this.recipe);
    this.carbs = this.recipeSvc.getTotalCarbs(this.recipe);
    this.protein = this.recipeSvc.getTotalProtein(this.recipe);
  }

}
