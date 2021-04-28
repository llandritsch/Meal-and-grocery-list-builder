import { Component, OnInit } from '@angular/core';
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

  goal: UserGoal = null;

  async ngOnInit(): Promise<void> {
    this.goal = await this.goalSvc.getUserGoal().toPromise();
  }

}
