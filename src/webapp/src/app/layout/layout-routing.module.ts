import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LanguageListComponent } from '../features/laguanges/language-list/language-list.component';
import { LayoutComponent } from './layout.component';
import { RiskLevelListComponent } from '../features/risk-level/risk-level-list/risk-level-list.component';
import { SkillListComponent } from '../features/skill/skill-list/skill-list.component';
import { InstitutionListComponent } from '../features/institution/institution-list/institution-list.component';
import { JobListComponent } from '../features/jobs/job-list/job-list.component';


const routes: Routes = [{
  path: '', component: LayoutComponent, children: [
    { path: 'languages', component: LanguageListComponent },
    { path: 'risk_levels', component: RiskLevelListComponent },
    { path: 'skills', component: SkillListComponent },
    { path: 'institutions', component: InstitutionListComponent },
    { path: 'jobs', component: JobListComponent}
    // },
    // { path: 'balance', loadChildren: () => import(`./balance/balance.module`).then(m => m.BalanceModule) },
    // {
    //   path: '', redirectTo: 'apply', pathMatch: 'full'
    // },
    // { path: '**', component: Page404leavesComponent
  ]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
