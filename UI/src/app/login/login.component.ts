import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {AuthenticationService} from "../services/authentication.service";
import {Router} from "@angular/router";

type Credentials = {
  username: string;
  password: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  ngOnInit(): void {
  }

  async onSubmit(form: NgForm): Promise<void> {
    const credentials: Credentials = form.value;
    const { username, password } = credentials;

    await this.authService.login(username, password);
    await this.router.navigateByUrl('/');
  }

}
