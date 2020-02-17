import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InstitutionListComponent } from './institution-list/institution-list.component';
import { InstitutionCreateComponent } from './institution-create/institution-create.component';
import { InstitutionUpdateComponent } from './institution-update/institution-update.component';
import { SharedModule } from '../../../shared/shared.module';



@NgModule({
  declarations: [
    InstitutionListComponent,
    InstitutionCreateComponent,
    InstitutionUpdateComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    InstitutionListComponent,
    InstitutionCreateComponent,
    InstitutionUpdateComponent]
})
export class InstitutionModule { }
