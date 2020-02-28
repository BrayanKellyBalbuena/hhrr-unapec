import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobListComponent } from './job-list/job-list.component';
import { JobCreateComponent } from './job-create/job-create.component';
import { JobUpdateComponent } from './job-update/job-update.component';
import { SharedModule } from '../../../shared/shared.module';
import { JobCandidateAppliedListComponent } from './jobs-candidates-applied-list/jobs-candidates-applied-list.component';


@NgModule({
  declarations: [
    JobListComponent,
    JobCreateComponent,
    JobUpdateComponent,
    JobCandidateAppliedListComponent,
   ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    JobListComponent,
    JobCreateComponent,
    JobUpdateComponent,
    JobCandidateAppliedListComponent,
    ]
})
export class JobModule { }
