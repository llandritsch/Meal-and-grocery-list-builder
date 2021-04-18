import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import { Observable } from "rxjs";

export type UserGoal = {
  id?: number;
  userId?: number;
  calorieGoal: number;
  carbGoal: number;
  fatGoal: number;
  proteinGoal: number;
}

@Injectable({
  providedIn: 'root'
})
export class UserGoalService {

  constructor(private http: HttpClient) { }

  rootURL = '/api/UsersService';

  createUserGoal(goal: UserGoal): Observable<UserGoal> {
    return this.http.post<UserGoal>(this.rootURL, goal);
  }
}
