import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../../../shared/shared.module';
import { TrainingListComponent } from './training-list/training-list.component';
import { TrainingUpdateComponent } from './training-update/training-update.component';
import { TrainingCreateComponent } from './training-create/training-create.component';



@NgModule({
  declarations: [
    TrainingListComponent,
    TrainingCreateComponent,
    TrainingUpdateComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    TrainingListComponent,
    TrainingCreateComponent,
    TrainingUpdateComponent]
})
export class TrainingModule { }
