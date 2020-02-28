import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CandidateTrainingListComponent } from './candidate-training-list/candidate-training-list.component';
import { CandidateTrainingUpdateComponent } from './candidate-training-update/candidate-training-update.component';
import { SharedModule } from '../../../../shared/shared.module';
import { CandidateTrainingCreateComponent } from './candidate-training-create/candidate-training-create.component';


@NgModule({
  declarations: [
    CandidateTrainingListComponent,
    CandidateTrainingCreateComponent,
    CandidateTrainingUpdateComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    CandidateTrainingListComponent,
    CandidateTrainingCreateComponent,
    CandidateTrainingUpdateComponent]
})
export class CandidateTrainingsModule { }
