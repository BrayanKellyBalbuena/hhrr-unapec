import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LanguageListComponent } from '../features/laguanges/language-list/language-list.component';
import { LayoutComponent } from './layout.component';


const routes: Routes = [{
  path: '', component: LayoutComponent, children: [
    {
      path: 'languages', component: LanguageListComponent
    // },
    // { path: 'balance', loadChildren: () => import(`./balance/balance.module`).then(m => m.BalanceModule) },
    // {
    //   path: '', redirectTo: 'apply', pathMatch: 'full'
    // },
    // { path: '**', component: Page404leavesComponent
  }
  ]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
