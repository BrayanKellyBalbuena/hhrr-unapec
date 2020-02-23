import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobListComponent } from './job-list/job-list.component';
import { JobCreateComponent } from './job-create/job-create.component';
import { JobUpdateComponent } from './job-update/job-update.component';
import { SharedModule } from '../../../shared/shared.module';


@NgModule({
  declarations: [
    JobListComponent,
    JobCreateComponent,
    JobUpdateComponent,
   ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    JobListComponent,
    JobCreateComponent,
    JobUpdateComponent,
    ]
})
export class JobModule { }
