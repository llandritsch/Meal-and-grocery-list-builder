import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import {ApiService} from "./api.service";

export type UserGoal = {
  id?: number;
  userid?: number;
  calorieGoal: number;
  carbGoal: number;
  fatGoal: number;
  proteinGoal: number;
}

@Injectable({
  providedIn: 'root'
})
export class UserGoalService {

  constructor(private http: ApiService) { }

  rootURL = '/api/GoalService';

  createUserGoal(goal: UserGoal): Observable<UserGoal> {
    const payload = {};
    Object.keys(goal).forEach(key => {
      payload[key] = parseInt(goal[key], 10);
    });
    return this.http.post<UserGoal>(this.rootURL + "/goals", payload);
  }

  getUserGoal(): Observable<UserGoal> {
    return this.http.get<UserGoal>(this.rootURL + "/goals");
  }
}
