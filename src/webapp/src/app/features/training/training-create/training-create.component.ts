import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { SkillWithIdName } from '../../skill/shared/skill-with-id-name';
import { PageRequest } from '../../../core/models/page-request';
import { ConcurrencyFormater } from '../../../../shared/formatters/concurrency-formater';
import { ConcurrencyParser } from '../../../../shared/parsers/concurrency-parser';
import { TrainingCreateCommand } from '../shared/training-create-command';
import { TrainingCommandService } from '../shared/training-command.service';
import { InstitutionQueryService } from '../../institution/shared/institution-query.service';

@Component({
  selector: 'app-training-create',
  templateUrl: './training-create.component.html',
  styleUrls: ['./training-create.component.css']
})
export class TrainingCreateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Create new Training';
  tempTraining: TrainingCreateCommand;
  institutions: SkillWithIdName[] = [];
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;
  concurrencyFormatter =  new ConcurrencyFormater();
  concurrencyParser = new ConcurrencyParser();
  formSubmitted = false;
  date = null;

  constructor(private serviceCommand: TrainingCommandService, private riksLevelQueryService: InstitutionQueryService) {
    this.tempTraining = new TrainingCreateCommand();
    this.tempTraining.name = null;
    this.tempTraining.description = null;
   }

  ngOnInit() {
    this.riksLevelQueryService.getWithIdName (PageRequest.init(20))
      .subscribe(data => this.institutions = data.content);
  }

   showModal(): void {
    this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    this.toggleSubmit();

    if (form.valid) {
      this.toggleIsOkLoading();
      this.serviceCommand.create(this.tempTraining)
      .subscribe(result => {
        this.showAlert = true;
        this.alert.success('Success');
        this.resetTempTraining();
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

  resetTempTraining() {
    this.tempTraining = new TrainingCreateCommand();
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  toggleSubmit() {
    this.formSubmitted = !this.formSubmitted;
  }

  dateToChange(event) {console.log(event); }

  dateFromChange(event) {}

}
