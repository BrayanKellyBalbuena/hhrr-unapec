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

  constructor(private serviceCommand: InstitutionCommandService) { }

  ngOnInit() {
    this.serviceCommand.create(this.tempInstitution);
  }

   showModal(): void {
    this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.toggleIsOkLoading();
      this.serviceCommand.create(this.tempInstitution)
      .subscribe(result => {
        this.showAlert = true;
        this.alert.success('Success');
        this.resetTempInstitution();
        this.toggleIsOkLoading();
        this.createCompleted.emit(true);
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

  resetTempInstitution() {
    this.tempInstitution = {name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
  }

}
