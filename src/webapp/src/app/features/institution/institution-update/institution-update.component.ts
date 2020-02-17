import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';

import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { InstitutionUpdateCommand } from '../shared/institution-update-command';
import { InstitutionCommandService } from '../shared/institution-command.service';



@Component({
  selector: 'app-institution-update',
  templateUrl: './institution-update.component.html',
  styleUrls: ['./institution-update.component.css']
})
export class InstitutionUpdateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Update Risk level';
  @Input() tempInstitution: InstitutionUpdateCommand = {id: 0, name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @Input() show = false;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() updateCompleted = new EventEmitter<boolean>();
  showAlert = false;

  constructor(private serviceCommand: InstitutionCommandService) { }

  ngOnInit() {

  }

   showModal(tempInstitution: InstitutionUpdateCommand): void {
     this.tempInstitution = tempInstitution;
     this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.isOkLoading = true;

      this.serviceCommand.update(this.tempInstitution)
      .subscribe(result => {
        this.showAlert = true;

        this.alert.success('Success');
        this.resetTempInstitution();
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

  resetTempInstitution() {
    this.tempInstitution = {id: 0, name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
    this.showAlert = false;
  }

}
