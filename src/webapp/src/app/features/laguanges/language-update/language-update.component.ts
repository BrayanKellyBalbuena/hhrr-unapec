import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';
import { LanguageCreateCommand } from '../shared/language-create-command';
import { LanguageCommandService } from '../shared/language-command.service';
import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { LanguageUpdateCommand } from '../shared/language-update-command';



@Component({
  selector: 'app-language-update',
  templateUrl: './language-update.component.html',
  styleUrls: ['./language-update.component.css']
})
export class LanguageUpdateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Update language';
  @Input() tempLanguage: LanguageUpdateCommand = {id: 0, name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @Input() show = false;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() updateCompleted = new EventEmitter<boolean>();
  showAlert = false;

  constructor(private serviceCommand: LanguageCommandService) { }

  ngOnInit() {

  }

   showModal(tempLanguage: LanguageUpdateCommand): void {
     this.tempLanguage = tempLanguage;
     this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.isOkLoading = true;

      this.serviceCommand.update(this.tempLanguage)
      .subscribe(result => {
        this.showAlert = true;

        this.alert.success('Success');
        this.resetTempLanguage();
        this.toggleIsOkLoading();
        this.handleCancel();
        this.updateCompleted.emit(true);
      },
        (errResponse: HttpErrorResponse) => {
          console.log(errResponse);
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
    this.tempLanguage = {id: 0, name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
    this.showAlert = false;
  }

}
