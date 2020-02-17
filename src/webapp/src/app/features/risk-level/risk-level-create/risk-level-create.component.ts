import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { RiskLevelCreateCommand } from '../shared/risk-level-create-command';
import { RiskLevelCommandService } from '../shared/risk-level-command.service';

@Component({
  selector: 'app-risk-level-create',
  templateUrl: './risk-level-create.component.html',
  styleUrls: ['./risk-level-create.component.css']
})
export class RiskLevelCreateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Create new RiskLevel';
  tempRiskLevel: RiskLevelCreateCommand = {name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;

  constructor(private serviceCommand: RiskLevelCommandService) { }

  ngOnInit() {
    this.serviceCommand.create(this.tempRiskLevel);
  }

   showModal(): void {
    this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.toggleIsOkLoading();
      this.serviceCommand.create(this.tempRiskLevel)
      .subscribe(result => {
        this.showAlert = true;
        this.alert.success('Success');
        this.resetTempRiskLevel();
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

  resetTempRiskLevel() {
    this.tempRiskLevel = {name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
  }

}
