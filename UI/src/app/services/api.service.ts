import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthenticationService} from "./authentication.service";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: HttpClient,
    private authService: AuthenticationService
  ) { }

  private getHeaders(): HttpHeaders {
    let headers: HttpHeaders = new HttpHeaders();
    const userToken = this.authService.getToken();
    if (userToken) {
      headers = headers.set("userToken", userToken.token);
    }
    return headers;
  }

  get<T>(url: string): Observable<T> {
    const headers = this.getHeaders();
    return this.http.get<T>(url, { headers });
  }

  delete<T>(url: string): Observable<T> {
    const headers = this.getHeaders();
    return this.http.delete<T>(url, { headers });
  }

  post<T>(url: string, body: any): Observable<T> {
    const headers = this.getHeaders();
    return this.http.post<T>(url, body, { headers });
  }

  put<T>(url: string, body: any): Observable<T> {
    const headers = this.getHeaders();
    return this.http.put<T>(url, body, { headers });
  }

}
