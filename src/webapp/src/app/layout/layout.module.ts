import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutRoutingModule } from './layout-routing.module';
import { FeaturesModule } from '../features/features.module';
import { LayoutComponent } from './layout.component';
import { SharedModule } from '../../shared/shared.module';
import { SigninSignupComponent } from './signin-signup/signin-signup.component';

@NgModule({
  declarations: [LayoutComponent, SigninSignupComponent],
  imports: [
    CommonModule,
    LayoutRoutingModule,
    FeaturesModule,
    SharedModule
  ],
  exports: []
})
export class LayoutModule { }
