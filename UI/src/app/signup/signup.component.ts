import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import { UserService, User } from '../services/user.service';
import { UserGoalService, UserGoal } from '../services/usergoal.service';
import { Observable } from "rxjs";

type UserAndGoal = User & UserGoal;

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private userService: UserService,
    private userGoalService: UserGoalService
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

    console.log("Create this user: ", userData);
    console.log("Create this user goal: ", userGoalData);


    // Create user first. The API will return back the created user
    // with its id property.
    const user = await this.userService.createUser(userData).toPromise();
    // Associate the goal to the user we just created...
    userGoalData.userid = user.id;
    // Then create the goal for that user
    await this.userGoalService.createUserGoal(userGoalData).toPromise();
  }

}
