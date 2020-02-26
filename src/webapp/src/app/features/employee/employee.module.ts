import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../../../shared/shared.module';
import { EmployeeListComponent } from './employee-list/employee-list-jobs.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  declarations: [EmployeeListComponent],
  exports: [
    EmployeeListComponent,
  ]
})
export class EmployeeModule { }
