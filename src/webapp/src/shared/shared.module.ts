import { NgModule } from '@angular/core';
import { NgZorroAntdModule, NzIconModule, } from 'ng-zorro-antd';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LanguageQueryService } from '../app/features/laguanges/shared/language-query.service';
import { LanguageCommandService } from '../app/features/laguanges/shared/language-command.service';
import { AlertComponent } from './alert/alert.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AlertComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NgZorroAntdModule,
    NzIconModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    NgZorroAntdModule,
    NzIconModule,
    FormsModule,
    ReactiveFormsModule,
    AlertComponent
   ],
    providers: [LanguageQueryService, LanguageCommandService]
})
export class SharedModule {

}
