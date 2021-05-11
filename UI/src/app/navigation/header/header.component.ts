import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {User, UserService} from "../../services/user.service";
import {AuthenticationService} from "../../services/authentication.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output() public sidenavToggle = new EventEmitter();

  constructor(
    private userService: UserService,
    private authService: AuthenticationService
  ) { }

  user: User;

  ngOnInit(): void {
    this.loadUser();
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }

  private async loadUser(): Promise<void> {
    this.user = await this.userService.getUser();
  }

  public onToggleSidenav = () => {
    this.sidenavToggle.emit();
  }

}
