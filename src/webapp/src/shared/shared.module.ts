import { NgModule } from '@angular/core';
import { NgZorroAntdModule, NzIconModule, } from 'ng-zorro-antd';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LanguageQueryService } from '../app/features/laguanges/shared/language-query.service';
import { LanguageCommandService } from '../app/features/laguanges/shared/language-command.service';
import { AlertComponent } from './alert/alert.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { AuthGuardService } from './services/auth-guard.service';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AlertComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    BrowserAnimationsModule,
    NgZorroAntdModule,
    NzIconModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
    BrowserModule,
    RouterModule,
    BrowserAnimationsModule,
    HttpClientModule,
    NgZorroAntdModule,
    NzIconModule,
    FormsModule,
    ReactiveFormsModule,
    AlertComponent
   ],
    providers: [LanguageQueryService, LanguageCommandService, AuthInterceptor, AuthGuardService]
})
export class SharedModule {

}
