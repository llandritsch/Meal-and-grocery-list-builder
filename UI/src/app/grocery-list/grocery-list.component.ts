import { Component, OnInit } from '@angular/core';
import { Recipe, RecipeIngredient } from '../services/recipes.service';
import {Menu, MenuService} from "../services/menu.service";

type GroceryListState = {
  [key: string]: RecipeIngredient[];
}

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {

  constructor(
    private menuSvc: MenuService
  ) {}

  groceriesBySection: GroceryListState = {};

  async ngOnInit(): Promise<void> {
    const menu: Menu = await this.menuSvc.getMenu();
    this.groupIngredientsBySection(menu);
  }

  hasGroceries(): boolean {
    return this.getSectionNames().length > 0;
  }

  getSectionNames(): string[] {
    return Object.keys(this.groceriesBySection);
  }

  getIngredientsForSection(section: string): RecipeIngredient[] {
    return this.groceriesBySection[section];
  }

  private groupIngredientsBySection(menu: Menu): void {
    menu.recipes.forEach((recipe: Recipe) => {
      recipe.ingredients.forEach((ingredient: RecipeIngredient) => {
        const { grocerySection } = ingredient;
        if (!this.groceriesBySection.hasOwnProperty(grocerySection)) {
          this.groceriesBySection[grocerySection] = [];
        }
        this.groceriesBySection[grocerySection].push(ingredient);
      });
    });
  }

}
