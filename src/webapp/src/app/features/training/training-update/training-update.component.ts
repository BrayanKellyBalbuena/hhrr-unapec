import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';

import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { TrainingUpdateCommand } from '../shared/training-update-command';
import { TrainingCommandService } from '../shared/training-command.service';
import { ConcurrencyFormater } from '../../../../shared/formatters/concurrency-formater';
import { ConcurrencyParser } from '../../../../shared/parsers/concurrency-parser';
import { InstitutionQueryService } from '../../institution/shared/institution-query.service';
import { InstitutionWithIdName } from '../../institution/shared/institution-with-id-name';
import { PageRequest } from '../../../core/models/page-request';



@Component({
  selector: 'app-training-update',
  templateUrl: './training-update.component.html',
  styleUrls: ['./training-update.component.css']
})
export class TrainingUpdateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Update Training';
  institutions: InstitutionWithIdName[] = [];
  @Input() tempTraining: TrainingUpdateCommand;
  @Output() OnCreated = new EventEmitter<boolean>();
  @Input() show = false;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() updateCompleted = new EventEmitter<boolean>();
  showAlert = false;
  concurrencyFormatter =  new ConcurrencyFormater();
  concurrencyParser = new  ConcurrencyParser();
  formSubmitted = false;

  constructor(private serviceCommand: TrainingCommandService,  private riksLevelQueryService: InstitutionQueryService) {
    this.tempTraining = new TrainingUpdateCommand();
   }

  ngOnInit() {
    this.riksLevelQueryService.getWithIdName (PageRequest.init(20))
      .subscribe(data => this.institutions = data.content);
  }

   showModal(tempTraining: TrainingUpdateCommand): void {
     this.tempTraining = tempTraining;
     this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    this.toggleSubmit();

    if (form.valid) {
      this.isOkLoading = true;

      this.serviceCommand.update(this.tempTraining)
      .subscribe(result => {
        this.showAlert = true;

        this.alert.success('Success');
        this.resetTempTraining();
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

  resetTempTraining() {
    this.tempTraining = new TrainingUpdateCommand();
  }

  handleCancel(): void {
    this.isVisible = false;
    this.showAlert = false;
  }

  toggleSubmit() {
    this.formSubmitted = !this.formSubmitted;
  }

  dateToChange($event) {console.log($event); }
  dateFromChange($event) {}

}
