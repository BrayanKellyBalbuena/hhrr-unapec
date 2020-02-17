import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RiskLevelListComponent } from './risk-level-list/risk-level-list.component';
import { RiskLevelCreateComponent } from './risk-level-create/risk-level-create.component';
import { RiskLevelUpdateComponent } from './risk-level-update/risk-level-update.component';
import { SharedModule } from '../../../shared/shared.module';



@NgModule({
  declarations: [
    RiskLevelListComponent,
    RiskLevelCreateComponent,
    RiskLevelUpdateComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    RiskLevelListComponent,
    RiskLevelCreateComponent,
    RiskLevelUpdateComponent]
})
export class RiskLevelModule { }
