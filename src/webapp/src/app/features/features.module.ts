import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../../shared/shared.module';
import { LaguangesModule } from './laguanges/laguanges.module';


@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    LaguangesModule,
  ],
  declarations: [],
  exports: [LaguangesModule]
})
export class FeaturesModule { }
