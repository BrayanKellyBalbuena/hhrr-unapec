import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { InstitutionCreateCommand } from '../shared/institution-create-command';
import { InstitutionCommandService } from '../shared/institution-command.service';

@Component({
  selector: 'app-institution-create',
  templateUrl: './institution-create.component.html',
  styleUrls: ['./institution-create.component.css']
})
export class InstitutionCreateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Create new Institution';
  tempInstitution: InstitutionCreateCommand = {name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;
  formSubmitted = false;

  constructor(private serviceCommand: InstitutionCommandService) { }

  ngOnInit() {
    this.serviceCommand.create(this.tempInstitution);
  }

   showModal(): void {
    this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    this.toggleSubmit();

    if (form.valid) {
      this.toggleIsOkLoading();
      this.serviceCommand.create(this.tempInstitution)
      .subscribe(() => {
        this.showAlert = true;

        this.alert.success('Success');
        this.resetTempInstitution();
        form.reset();
        this.toggleIsOkLoading();
        this.toggleSubmit();
        this.createCompleted.emit(true);
      },
        (errResponse: HttpErrorResponse) => {
          this.showAlert = true;

          this.alert.error(errResponse.error['error'], errResponse.error['message']);
          this.toggleIsOkLoading();
      });
    } else {
      this.alert.warn('Complete all required values');
    }
  }

  toggleIsOkLoading() {
    this.isOkLoading = !this.isOkLoading;
  }

  resetTempInstitution() {
    this.tempInstitution = {name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  toggleSubmit() {
    this.formSubmitted = !this.formSubmitted;
  }

}
