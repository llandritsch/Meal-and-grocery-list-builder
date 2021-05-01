import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ApiService} from "./api.service";
import {HttpClient} from "@angular/common/http";

export type User = {
  id?: number;
  userName: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private apiService: ApiService,
    private http: HttpClient
  ) { }

  rootURL = '/api/UserService/users';

  private user: User;

  // Get the currently logged-in user
  async getUser(): Promise<User> {
    if (this.user) {
      return this.user;
    }
    const user = await this.apiService.get<User>(this.rootURL).toPromise();
    this.user = user
    return user;
  }

  // Register an unauthenticated user
  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.rootURL, user);
  }
}
