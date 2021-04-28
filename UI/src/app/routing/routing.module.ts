import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent} from "../index/index.component";
import { SignupComponent } from "../signup/signup.component";
import {RecipesComponent} from "../recipes/recipes.component";
import {MenuComponent} from "../menu/menu.component";
import {GroceryListComponent} from "../grocery-list/grocery-list.component";
import { AuthGuardService } from "../services/authguard.service";
import { LoginComponent } from "../login/login.component";
import {AddRecipeComponent} from "../add-recipe/add-recipe.component";

const routes: Routes = [
  // Routes that do not require authentication
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  // Routes that DO require authentication
  { path: 'index', component: IndexComponent, canActivate: [AuthGuardService] },
  { path: '',redirectTo: '/index', pathMatch: 'full' },
  { path: 'browse', component: RecipesComponent, canActivate: [AuthGuardService] },
  { path: 'menu', component: MenuComponent, canActivate: [AuthGuardService] },
  { path: 'groceryList', component: GroceryListComponent, canActivate: [AuthGuardService] },
  { path: 'add-recipe', component: AddRecipeComponent, canActivate: [AuthGuardService] }
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
