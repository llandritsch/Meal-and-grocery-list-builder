import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent} from "../index/index.component";
import { SignupComponent } from "../signup/signup.component";
import {RecipesComponent} from "../recipes/recipes.component";
import {MenuComponent} from "../menu/menu.component";
import {GroceryListComponent} from "../grocery-list/grocery-list.component";

const routes: Routes = [
  { path: 'index', component: IndexComponent },
  { path: '',redirectTo: '/index', pathMatch: 'full' },
  { path: 'signup', component: SignupComponent },
  { path: 'browse', component: RecipesComponent },
  { path: 'menu', component: MenuComponent},
  { path: 'groceryList', component: GroceryListComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
