import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CandidateCreateComponent } from './candidate-create/candidate-create.component';
import { SharedModule } from '../../../shared/shared.module';
import { CandidateSkillListComponent } from './candidate-skill-list/candidate-skill-list.component';
import { CandidateAddSkillComponent } from './candidate-add-skill/candidate-add-skill.component';
import { CandidateJobSeachListComponent } from './candidate-search-jobs/candidate-search-jobs.component';
import { CandidateAddLanguageComponent } from './candidate-add-language/candidate-add-language.component';
import { CandidateLanguageListComponent } from './candidate-language-list/candidate-language-list.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  declarations: [CandidateCreateComponent,
     CandidateSkillListComponent,
    CandidateAddSkillComponent,
    CandidateJobSeachListComponent,
    CandidateAddLanguageComponent,
  CandidateLanguageListComponent],
  exports:[
    CandidateCreateComponent,
    CandidateSkillListComponent,
    CandidateAddLanguageComponent,
    CandidateLanguageListComponent,
    CandidateAddSkillComponent,
    CandidateJobSeachListComponent,
  ]
})
export class CandidateModule { }
