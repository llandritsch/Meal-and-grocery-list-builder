import { Component, OnInit } from '@angular/core';
import { UserService, User } from '../services/user.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private indexSvc: UserService) { }

    users: Observable<User[]> = null;

  ngOnInit(): void {
    this.users = this.indexSvc.getUsers();
  }

}
