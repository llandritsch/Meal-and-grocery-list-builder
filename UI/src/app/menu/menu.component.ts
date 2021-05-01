import { Component, OnInit } from '@angular/core';
import {Menu, MenuService} from "../services/menu.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public menuService: MenuService) {}

  menu: Menu;

  async ngOnInit(): Promise<void> {
    this.menu = await this.menuService.getMenu();
  }

  userHasMenu(): boolean {
    return this.menu && this.menu.recipes.length > 0;
  }
}
