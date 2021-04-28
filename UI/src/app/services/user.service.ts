import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ApiService} from "./api.service";

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
    private http: ApiService,
  ) { }

  rootURL = '/api/UserService';

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.rootURL + "/users");
  }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.rootURL + "/users", user);
  }
}
