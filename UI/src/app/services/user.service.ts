import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthenticationService} from "./authentication.service";

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
    private http: HttpClient,
    private authService: AuthenticationService
  ) { }

  rootURL = '/api/UserService';

  getUsers(): Observable<User[]> {
    // Instantiate some headers
    let headers: HttpHeaders = new HttpHeaders();
    // Get the current auth token
    const userToken = this.authService.getToken();
    let tokenString = "";
    // If this is null, it means the user is not signed in.
    // If not, it means we have an AuthenticationToken and should
    // grab its ".token" property, which is the string GUID of the
    // token.
    if (userToken) {
      tokenString = userToken.token;
    }
    // HACK: I'm hard-coding in a token that's already in the database
    // to demonstrate it works. Remove this line once you have the ability
    // to sign in a user via username/password.
    tokenString = "2824c4c5-f437-4027-88f6-b5f67c038f3b";
    headers = headers.set("userToken", tokenString);
    return this.http.get<User[]>(this.rootURL + "/users", { headers: headers });
  }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.rootURL + "/users", user);
  }
}
