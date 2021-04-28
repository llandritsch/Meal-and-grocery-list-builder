import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import { UserService, User } from '../services/user.service';
import { UserGoalService, UserGoal } from '../services/usergoal.service';
import { Observable } from "rxjs";
import {AuthenticationService} from "../services/authentication.service";
import {Router} from "@angular/router";

type UserAndGoal = User & UserGoal;

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private userService: UserService,
    private userGoalService: UserGoalService,
    private authService: AuthenticationService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
  }

  async onSubmit(form: NgForm) {
    // A mix of user data and user goal data
    const userAndGoalData: UserAndGoal = form.value;
    // Separate out the data specific to the User service
    const userData: User = {
      userName: userAndGoalData.userName,
      password: userAndGoalData.password
    };
    // Separate out the data specific to the UserGoal service
    const userGoalData: UserGoal = {
      calorieGoal: userAndGoalData.calorieGoal,
      fatGoal: userAndGoalData.fatGoal,
      carbGoal: userAndGoalData.carbGoal,
      proteinGoal: userAndGoalData.proteinGoal
    };

    // Create user first.
    await this.userService.createUser(userData).toPromise();
    // Log in as the user
    await this.authService.login(userData.userName, userData.password);
    // Then create the goal for that user
    await this.userGoalService.createUserGoal(userGoalData).toPromise();
    // Finally, redirect to the home page
    await this.router.navigateByUrl('/');
  }

}
