import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ApiService} from "./api.service";
import {HttpClient} from "@angular/common/http";
import {PlatformLocation} from "@angular/common";

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
    private http: HttpClient,
    private platformLocation: PlatformLocation
  ) {
    this.rootURL = platformLocation.getBaseHrefFromDOM() + "api/UserService/users";
  }

  private readonly rootURL;

  // Get the currently logged-in user
  async getUser(): Promise<User> {
    return await this.apiService.get<User>(this.rootURL).toPromise();
  }

  // Register an unauthenticated user
  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.rootURL, user);
  }
}
