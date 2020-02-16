import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';

const routes: Routes = [
    { path: '', component: LayoutComponent},
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
