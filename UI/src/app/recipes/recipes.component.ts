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

}
