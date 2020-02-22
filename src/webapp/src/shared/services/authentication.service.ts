import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { UserSigninCommnad } from "./user-signin-commnad";
import { shareReplay, tap } from "rxjs/operators";
import { endPoints } from "../../environments/environment";

import * as moment from "moment";
import { AuthResult } from "./auth-result";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { NzMessageService } from "ng-zorro-antd";
import { LoginResult } from "../../app/features/security/login/login-result";
import { CurrentUser } from '../../app/core/models/user';

@Injectable({
  providedIn: "root"
})
export class AuthenticationService {
  private TOKEN = "token";
  private EXPIRES_AT = "expires_at";
  private USER = "user";
  constructor(private http: HttpClient, private router: Router) {}

  login(userSigninCommnad: UserSigninCommnad) {
    return this.http.post<AuthResult>(endPoints.signin, userSigninCommnad).pipe(
      tap(e => {
        this.setSession(e);
        this.router.navigate([""]);
      })
    );
  }

  private setSession(authResult: AuthResult) {
    const expiresAt = authResult.expirationDate;

    localStorage.setItem(this.TOKEN, authResult.token);
    localStorage.setItem(this.EXPIRES_AT, JSON.stringify(expiresAt.valueOf()));
    localStorage.setItem(
      this.USER,
      JSON.stringify({
        username: authResult.username,
        email: authResult.email,
        roles: authResult.roles
      })
    );
  }

  logout() {
    localStorage.removeItem(this.TOKEN);
    localStorage.removeItem(this.EXPIRES_AT);
    localStorage.removeItem(this.USER);

    this.router.navigate(["login"]);
  }

  public isLoggedIn() {
    return new Date().valueOf() < this.getExpiration();
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration(): number {
    const expiration = localStorage.getItem(this.EXPIRES_AT);
    const expiresAt = JSON.parse(expiration);
    return new Date(expiresAt).valueOf();
  }

  getCurrentUser(): CurrentUser {
    const currentUser: CurrentUser = JSON.parse(localStorage.getItem('user'));
    return currentUser;
  }
}
