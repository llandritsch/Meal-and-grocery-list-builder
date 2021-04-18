import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export type User = {
  id?: number;
  userName: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  rootURL = '/api/UserService';

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.rootURL + "/users");
  }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.rootURL, user);
  }
}
