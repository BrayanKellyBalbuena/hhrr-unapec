import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../../shared/shared.module';
import { LaguangesModule } from './laguanges/laguanges.module';
import { RiskLevelModule } from './risk-level/risk-label.module';
import { SkillModule } from './skill/skill.module';
import { InstitutionModule } from './institution/institution.module';
import { JobModule } from './jobs/job.module';
import { TrainingModule } from './training/training.module';


@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    LaguangesModule,
    RiskLevelModule,
    SkillModule,
    InstitutionModule,
    JobModule,
    TrainingModule,
  ],
  declarations: [],
  exports: [
    LaguangesModule,
    RiskLevelModule,
    SkillModule,
    InstitutionModule,
    JobModule,
    TrainingModule
  ]
})
export class FeaturesModule { }
