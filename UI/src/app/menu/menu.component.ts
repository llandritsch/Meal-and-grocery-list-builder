import { Component, OnInit } from '@angular/core';
import {Menu, MenuService} from "../services/menu.service";
import {Recipe, RecipesService} from "../services/recipes.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(
    private menuService: MenuService,
    private recipeSvc: RecipesService,
    private router: Router
  ) {}

  menu: Menu;

  async ngOnInit(): Promise<void> {
    await this.loadMenu();
  }

  async loadMenu(): Promise<void> {
    this.menu = await this.menuService.getMenu();
  }

  userHasMenu(): boolean {
    return this.menu && this.menu.recipes.length > 0;
  }

  async removeFromMenu(recipe: Recipe): Promise<void> {
    await this.menuService.removeFromMenu(recipe);
    await this.loadMenu();
  }

  async viewRecipe(recipeId) {
    await this.router.navigate(["/view-recipe/"], { queryParams: {id: recipeId} });
  }

  getTotalProtein(recipe: Recipe): number {
    return this.recipeSvc.getTotalProtein(recipe);
  }

  getTotalCarbs(recipe: Recipe): number {
    return this.recipeSvc.getTotalCarbs(recipe);
  }

  getTotalFat(recipe: Recipe): number {
    return this.recipeSvc.getTotalFat(recipe);
  }

}
