import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';

import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { JobUpdateCommand } from '../shared/job-update-command';
import { JobCommandService } from '../shared/job-command.service';
import { ConcurrencyFormater } from '../../../../shared/formatters/concurrency-formater';
import { ConcurrencyParser } from '../../../../shared/parsers/concurrency-parser';
import { RiskLevelQueryService } from '../../risk-level/shared/risk-level-query.service';
import { SkillWithIdName } from '../../skill/shared/skill-with-id-name';
import { PageRequest } from '../../../core/models/page-request';



@Component({
  selector: 'app-job-update',
  templateUrl: './job-update.component.html',
  styleUrls: ['./job-update.component.css']
})
export class JobUpdateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Update Job';
  skills: SkillWithIdName[] = [];
  @Input() tempJob: JobUpdateCommand;
  @Output() OnCreated = new EventEmitter<boolean>();
  @Input() show = false;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() updateCompleted = new EventEmitter<boolean>();
  showAlert = false;
  concurrencyFormatter =  new ConcurrencyFormater();
  concurrencyParser = new  ConcurrencyParser();
  formSubmitted = false;

  constructor(private serviceCommand: JobCommandService,  private riksLevelQueryService: RiskLevelQueryService) {
    this.tempJob = new JobUpdateCommand();
   }

  ngOnInit() {
    this.riksLevelQueryService.getWithIdName (PageRequest.init(20))
      .subscribe(data => this.skills = data.content);
  }

   showModal(tempJob: JobUpdateCommand): void {
     this.tempJob = tempJob;
     this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    this.toggleSubmit();

    if (form.valid) {
      this.isOkLoading = true;

      this.serviceCommand.update(this.tempJob)
      .subscribe(result => {
        this.showAlert = true;

        this.alert.success('Success');
        this.resetTempJob();
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
    } else {
      this.alert.warn('Complete all required values');
    }
  }

  toggleIsOkLoading() {
    this.isOkLoading = !this.isOkLoading;
  }

  resetTempJob() {
    this.tempJob = new JobUpdateCommand();
  }

  handleCancel(): void {
    this.isVisible = false;
    this.showAlert = false;
  }

  toggleSubmit() {
    this.formSubmitted = !this.formSubmitted;
  }

}
