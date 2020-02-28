import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SkillListComponent } from './skill-list/skill-list.component';
import { SkillCreateComponent } from './skill-create/skill-create.component';
import { SkillUpdateComponent } from './skill-update/skill-update.component';
import { SharedModule } from '../../../shared/shared.module';



@NgModule({
  declarations: [
    SkillListComponent,
    SkillCreateComponent,
    SkillUpdateComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    SkillListComponent,
    SkillCreateComponent,
    SkillUpdateComponent]
})
export class SkillModule { }
