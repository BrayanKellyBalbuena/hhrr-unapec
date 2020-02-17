import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';

import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { RiskLevelUpdateCommand } from '../shared/risk-level-update-command';
import { RiskLevelCommandService } from '../shared/risk-level-command.service';



@Component({
  selector: 'app-risk-level-update',
  templateUrl: './risk-level-update.component.html',
  styleUrls: ['./risk-level-update.component.css']
})
export class RiskLevelUpdateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Update Risk level';
  @Input() tempRiskLevel: RiskLevelUpdateCommand = {id: 0, name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @Input() show = false;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() updateCompleted = new EventEmitter<boolean>();
  showAlert = false;

  constructor(private serviceCommand: RiskLevelCommandService) { }

  ngOnInit() {

  }

   showModal(tempRiskLevel: RiskLevelUpdateCommand): void {
     this.tempRiskLevel = tempRiskLevel;
     this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.isOkLoading = true;

      this.serviceCommand.update(this.tempRiskLevel)
      .subscribe(result => {
        this.showAlert = true;

        this.alert.success('Success');
        this.resetTempRiskLevel();
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

  resetTempRiskLevel() {
    this.tempRiskLevel = {id: 0, name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
    this.showAlert = false;
  }

}
