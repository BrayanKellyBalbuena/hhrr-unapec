import { Component, OnInit, ViewChild } from '@angular/core';
import { LoginComponent } from '../../features/security/login/login.component';

@Component({
  selector: 'app-signin-signup',
  templateUrl: './signin-signup.component.html',
  styleUrls: ['./signin-signup.component.css']
})
export class SigninSignupComponent implements OnInit {

  @ViewChild(LoginComponent, {static: false}) login: LoginComponent;

  displayRegister = false;

  tabs = [
    {
      active: true,
      name: 'Signin',
      icon: 'apple'
    },
    {
      active: false,
      name: 'Signup',
      icon: 'android'
    }
  ];

  constructor() {

  }

  ngOnInit() {
  }

  onDisplay($event) {
    this.displayRegister = $event;
    console.log($event);
  }

}
