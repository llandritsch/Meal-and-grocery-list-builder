import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface IUser {
  userName: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  rootURL = '/api/v2';

  getUserName(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.rootURL + '/users');
  }

  //createUser(): Observable<IUser> {

  //}
}
