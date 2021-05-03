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

  async ngOnInit(): Promise<void> {
    await this.loadRecipe(this.id);
  }

  async loadRecipe(id): Promise<void> {
    this.recipe = await this.recipeSvc.getRecipeById(id);
  }
}
