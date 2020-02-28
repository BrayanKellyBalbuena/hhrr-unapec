import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { JobCreateCommand } from '../shared/job-create-command';
import { JobCommandService } from '../shared/job-command.service';
import { SkillWithIdName } from '../../skill/shared/skill-with-id-name';
import { PageRequest } from '../../../core/models/page-request';
import { RiskLevelQueryService } from '../../risk-level/shared/risk-level-query.service';
import { ConcurrencyFormater } from '../../../../shared/formatters/concurrency-formater';
import { ConcurrencyParser } from '../../../../shared/parsers/concurrency-parser';

@Component({
  selector: 'app-job-create',
  templateUrl: './job-create.component.html',
  styleUrls: ['./job-create.component.css']
})
export class JobCreateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Create new Job';
  tempJob: JobCreateCommand;
  skills: SkillWithIdName[] = [];
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;
  concurrencyFormatter =  new ConcurrencyFormater();
  concurrencyParser = new ConcurrencyParser();
  formSubmitted = false;
  constructor(private serviceCommand: JobCommandService, private riksLevelQueryService: RiskLevelQueryService) {
    this.tempJob = new JobCreateCommand();
    this.tempJob.name = null;
    this.tempJob.description = null;
   }

  ngOnInit() {
    this.riksLevelQueryService.getWithIdName (PageRequest.init(20))
      .subscribe(data => this.skills = data.content);
  }

   showModal(): void {
    this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    this.toggleSubmit();

    if (form.valid) {
      this.toggleIsOkLoading();
      this.serviceCommand.create(this.tempJob)
      .subscribe(result => {
        this.showAlert = true;
        this.alert.success('Success');
        this.resetTempJob();
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

  resetTempJob() {
    this.tempJob = new JobCreateCommand();
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  toggleSubmit() {
    this.formSubmitted = !this.formSubmitted;
  }

}
