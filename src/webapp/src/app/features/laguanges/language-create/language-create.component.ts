import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { LanguageCreateCommand } from '../shared/language-create-command';
import { LanguageCommandService } from '../shared/language-command.service';
import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-language-create',
  templateUrl: './language-create.component.html',
  styleUrls: ['./language-create.component.css']
})
export class LanguageCreateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Create new language';
  tempLanguage: LanguageCreateCommand = {name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;

  constructor(private serviceCommand: LanguageCommandService) { }

  ngOnInit() {
    this.serviceCommand.create(this.tempLanguage);
  }

   showModal(): void {
    this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.toggleIsOkLoading();
      this.serviceCommand.create(this.tempLanguage)
      .subscribe(result => {
        this.showAlert = true;
        this.alert.success('Success');
        this.resetTempLanguage();
        this.toggleIsOkLoading();
        this.createCompleted.emit(true);
        form.reset();
      },
        (errResponse: HttpErrorResponse) => {
          this.showAlert = true;

          this.alert.error(errResponse.error['error'], errResponse.error['message']);
          this.toggleIsOkLoading();
        });
    }
  }

  toggleIsOkLoading() {
    this.isOkLoading = !this.isOkLoading;
  }

  resetTempLanguage() {
    this.tempLanguage = {name: ' ', description: ''};
  }

  handleCancel(): void {
    this.isVisible = false;
  }

}
