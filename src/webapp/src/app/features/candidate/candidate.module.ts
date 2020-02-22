import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CandidateCreateComponent } from './candidate-create/candidate-create.component';
import { SharedModule } from '../../../shared/shared.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  declarations: [CandidateCreateComponent],
  exports:[CandidateCreateComponent]
})
export class CandidateModule { }
