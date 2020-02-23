import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CandidateCreateComponent } from './candidate-create/candidate-create.component';
import { SharedModule } from '../../../shared/shared.module';
import { CandidateSkillListComponent } from './candidate-skill-list/candidate-skill-list.component';
import { CandidateAddSkillComponent } from './candidate-add-skill/candidate-add-skill.component';
import { CandidateJobSeachListComponent } from './candidate-search-jobs/candidate-search-jobs.component';
import { CandidateAddLanguageComponent } from './candidate-add-language/candidate-add-language.component';
import { CandidateLanguageListComponent } from './candidate-language-list/candidate-language-list.component';
import { CandidateAppliedJobsListComponent } from './candidate-applied-jobs/candidate-applied-jobs.component';
import { CandidateTrainingListComponent } from './candidate-trainings/candidate-training-list/candidate-training-list.component';
import { CandidateTrainingsModule } from './candidate-trainings/candidate-training.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    CandidateTrainingsModule,
  ],
  declarations: [CandidateCreateComponent,
     CandidateSkillListComponent,
    CandidateAddSkillComponent,
    CandidateJobSeachListComponent,
    CandidateAddLanguageComponent,
  CandidateLanguageListComponent,
CandidateAppliedJobsListComponent],

  exports: [
    CandidateCreateComponent,
    CandidateSkillListComponent,
    CandidateAddLanguageComponent,
    CandidateLanguageListComponent,
    CandidateAddSkillComponent,
    CandidateJobSeachListComponent,
    CandidateAppliedJobsListComponent,
    CandidateTrainingsModule
  ]
})
export class CandidateModule { }
