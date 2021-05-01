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

  /* TODO: BUG: Username not updating after changing users.
    Steps:
      1. Sign in as user A
      2. Sign out
      3. Sign in as user B

    Expected: User B's name should be display
    Actual: User A's name is still displayed
   */

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
