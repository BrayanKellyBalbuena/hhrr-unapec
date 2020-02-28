import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LanguageListComponent } from './language-list/language-list.component';
import { LanguageCreateComponent } from './language-create/language-create.component';
import { SharedModule } from '../../../shared/shared.module';
import { LanguageUpdateComponent } from './language-update/language-update.component';


@NgModule({
  declarations: [
    LanguageListComponent,
    LanguageCreateComponent,
    LanguageUpdateComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    LanguageListComponent,
    LanguageCreateComponent,
    LanguageUpdateComponent]
})
export class LaguangesModule { }
