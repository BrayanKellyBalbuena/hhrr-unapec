import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LanguageListComponent } from '../features/laguanges/language-list/language-list.component';
import { LayoutComponent } from './layout.component';
import { RiskLevelListComponent } from '../features/risk-level/risk-level-list/risk-level-list.component';
import { SkillListComponent } from '../features/skill/skill-list/skill-list.component';
import { InstitutionListComponent } from '../features/institution/institution-list/institution-list.component';
import { JobListComponent } from '../features/jobs/job-list/job-list.component';
import { TrainingListComponent } from '../features/training/training-list/training-list.component';
import { CandidateSkillListComponent } from '../features/candidate/candidate-skill-list/candidate-skill-list.component';
import { CandidateJobSeachListComponent } from '../features/candidate/candidate-search-jobs/candidate-search-jobs.component';
import { CandidateLanguageListComponent } from '../features/candidate/candidate-language-list/candidate-language-list.component';


const routes: Routes = [{
  path: '', component: LayoutComponent, children: [
    { path: 'languages', component: LanguageListComponent },
    { path: 'risk_levels', component: RiskLevelListComponent },
    { path: 'skills', component: SkillListComponent },
    { path: 'institutions', component: InstitutionListComponent },
    { path: 'jobs', component: JobListComponent},
    { path: 'trainings', component: TrainingListComponent},
    {path: 'candidate-skills', component: CandidateSkillListComponent},
    {path: 'candidate-jobs-seach', component: CandidateJobSeachListComponent},
    {path: 'candidate-languages', component: CandidateLanguageListComponent}
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
