import { Component, OnInit } from '@angular/core';
import { UserService, User } from '../services/user.service';
import {Observable} from "rxjs";
import {UserGoal, UserGoalService} from '../services/usergoal.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(
    private goalSvc: UserGoalService
  ) { }

  goal: Observable<UserGoal> = null;


  ngOnInit(): void {
    this.goal = this.goalSvc.getUserGoal();
  }

}
