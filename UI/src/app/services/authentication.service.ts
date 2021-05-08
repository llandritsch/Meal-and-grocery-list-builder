import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PlatformLocation} from "@angular/common";

export type AuthenticationToken = {
  userId: number;
  token: string;
  expired: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private http: HttpClient,
    private platformLocation: PlatformLocation
  ) {
    this.rootURL = platformLocation.getBaseHrefFromDOM() + "api/auth";
  }

  private readonly rootURL;
  private key = "authToken";

  getToken(): AuthenticationToken {
    return JSON.parse(localStorage.getItem(this.key));
  }

  isAuthenticated(): boolean {
    return this.getToken() != null;
  }

  // A method to sign a user in via username/password.
  // It sends the credentials to the auth API and then
  // stores the returned AuthenticationToken object for later usage.
  async login(username: string, password: string): Promise<void> {
    // Create a user token by authenticating with a username and password against
    // the API.
    const authToken = await this.http.post<AuthenticationToken>(this.rootURL, {
      username,
      password
    }).toPromise();
    // Store the returned auth token in localStorage. Other HTTP calls will need to use
    // this token by attaching it as a "userToken" header to the request. They can get
    // the current token via the "getToken()" method above.
    localStorage.setItem(this.key, JSON.stringify(authToken));
  }

  // Sign a user out by calling DELETE with the token string in the URL
  async logout(): Promise<void> {
    await this.http.delete(`${this.rootURL}/${this.getToken().token}`).toPromise();
    localStorage.removeItem(this.key);
  }
}

