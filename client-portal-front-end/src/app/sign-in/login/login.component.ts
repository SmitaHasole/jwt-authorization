import { Component, OnInit, ViewEncapsulation, transition } from '@angular/core';
import { UserService } from 'app/user.service';
import { TokenStorage } from 'app/tokenStorage';
import { Router } from '@angular/router';
import { error } from 'selenium-webdriver';
import { User } from 'app/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  isError: boolean;
  user: User;
  constructor(private userService: UserService, private token: TokenStorage, private router: Router) { }

  ngOnInit() {
  }
  login(): void {
    console.log('hello', this.username, this.password);
    this.userService.attemptAuth(this.username, this.password).subscribe(
      data => {
        console.log('hello00000000000000', data);
        this.token.saveToken(data.token);
        this.user = new User();
        this.user.role = data.role;
        this.user.userName = data.userName;
        if (data.role.match('Patient')) {
          this.router.navigate(['user']);
        } else {
          this.router.navigate(['user/clinician']);
        }
      },
      error => {
        this.isError = true;
      }
    );
  }
}
