import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  constructor(private http: HttpClient) { }

  rootURL = '/api';

  getUserName() {
    return this.http.get(this.rootURL + '/test');
  }
}
