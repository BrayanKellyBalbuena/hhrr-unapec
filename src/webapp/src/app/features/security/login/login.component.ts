import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AuthenticationService } from "../../../../shared/services/authentication.service";
import { NzMessageService } from "ng-zorro-antd";
import { LoginResult } from "./login-result";
import { HttpErrorResponse } from '@angular/common/http';
import { HttpStatusCode } from '../../../core/enums/http-status-code.enum';

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  validateForm: FormGroup;
  isLoading = false;

  constructor(
    private fb: FormBuilder,
    private authService: AuthenticationService,
    private messageService: NzMessageService
  ) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

  submitForm() {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }

    if (this.validateForm.valid) {
      this.toggleLoading();
      this.authService.login(this.validateForm.value)
      .subscribe(
        ()  => {this.toggleLoading()}
      , (err: HttpErrorResponse) => {
        console.log(err);
        if (err.status === HttpStatusCode.UNAUTHORIZED ) {
              this.messageService.error("Username or password it's wrong");
              this.toggleLoading();
         }
      }) ;
    }
  }

  toggleLoading() {
    this.isLoading = !this.isLoading;
  }
}
