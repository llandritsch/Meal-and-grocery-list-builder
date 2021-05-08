import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import {ApiService} from "./api.service";
import {PlatformLocation} from "@angular/common";

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

  constructor(
    private http: ApiService,
    private platformLocation: PlatformLocation
  ) {
    this.rootURL = platformLocation.getBaseHrefFromDOM() + "api/GoalService";
  }

  private readonly rootURL;

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
