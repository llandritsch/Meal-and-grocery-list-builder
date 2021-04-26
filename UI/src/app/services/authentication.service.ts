import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export type AuthenticationToken = {
  userId: number;
  token: string;
  expired: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  rootURL = '/api/auth';
  authenticationToken: AuthenticationToken = null;

  getToken(): AuthenticationToken {
    return this.authenticationToken;
  }

  // A method to sign a user in via username/password.
  // It sends the crednetials to the auth API and then
  // stores the returned AuthenticationToken object for later usage.
  async login(username: string, password: string): Promise<void> {
    // Create a user token by authenticating with a username and password against
    // the API.
    const authToken = await this.http.post<AuthenticationToken>(this.rootURL, {
      username,
      password
    }).toPromise();
    // Store the returned auth token in this service. Other HTTP calls will need to use
    // this token by attaching it as a "userToken" header to the request. They can get
    // the current token via the "getToken()" method above.
    this.authenticationToken = authToken;
  }

  // Sign a user out by calling DELETE with the token string in the URL
  logout(): Observable<Object> {
    return this.http.delete(`${this.rootURL}/${this.getToken().token}`);
  }
}
