import { Component, OnInit } from '@angular/core';
import {Menu, MenuService} from "../services/menu.service";
import {Recipe} from "../services/recipes.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(
    public menuService: MenuService,
    public router: Router
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

  viewRecipe(recipeId) {
    this.router.navigate(["/view-recipe/"], { queryParams: {id: recipeId}
    });
  }

}
