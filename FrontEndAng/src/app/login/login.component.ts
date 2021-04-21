import { Component, OnInit } from '@angular/core';
import { Login } from './login';
import { InterfaceUtil } from '../core/interfaceUtil';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginInterface: Login;
  message = '';

  constructor(private loginService: LoginService,
              private router: Router) { }

  login(): void {
    this.loginService.loginUserFromRemote(this.loginInterface).subscribe(
      data => {console.log('response received'),
        this.router.navigate(['']);
      },
      error => {console.log('exception occured'),
        this.message = 'Bad credentials! Please enter valid Email and Password';
      });
  }

  ngOnInit(): void {
    this.loginInterface = InterfaceUtil.getEmptyLogin();
  }
}

