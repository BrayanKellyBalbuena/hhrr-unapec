import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { SigninSignupComponent } from './layout/signin-signup/signin-signup.component';
import { AuthGuardService as AuthGuard  } from '../shared/services/auth-guard.service';
import { LoginComponent } from './features/security/login/login.component';
import { CandidateCreateComponent } from './features/candidate/candidate-create/candidate-create.component';

const routes: Routes = [
    {path: '', component: LayoutComponent, canActivate: [AuthGuard]},
    {path: 'candidate-register', component: CandidateCreateComponent},
    {path: 'login', component: LoginComponent},
    // { path: 'profile', component: ProfileComponent },
    // { path: 'attendance', component: AttendanceComponent },
    { path: 'home', loadChildren: () => import(`./layout/layout.module`).then(m => m.LayoutModule) },
    { path: '', redirectTo: '', pathMatch: 'full' },
    // { path: '**', component: Page404Component },
];
@NgModule({
    imports: [RouterModule.forRoot(routes,{ enableTracing: false })],
    exports: [RouterModule]
})
export class AppRoutingModule  { }
