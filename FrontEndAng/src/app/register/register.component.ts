import { Component, OnInit } from '@angular/core';
import {Register} from './register';
import {InterfaceUtil} from '../core/interfaceUtil';
import { RegisterService } from '../service/register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  registerInterface: Register;
  message = '';

  constructor(private registerService: RegisterService, private router: Router) { }

  register(): void{
    this.registerService.registerUserFromRemote(this.registerInterface).subscribe(
      data => {console.log('Response received'),
        this.router.navigate(['login']);
      },
      error => {console.log('error occured'),
        this.message = 'Registration failed! Check required fields';
      });
  }

  ngOnInit(): void {
    this.registerInterface = InterfaceUtil.getEmptyRegister();
  }
}
