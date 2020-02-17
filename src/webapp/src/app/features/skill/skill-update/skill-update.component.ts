import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';

import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { SkillUpdateCommand } from '../shared/skill-update-command';
import { SkillCommandService } from '../shared/skill-command.service';



@Component({
  selector: 'app-skill-update',
  templateUrl: './skill-update.component.html',
  styleUrls: ['./skill-update.component.css']
})
export class SkillUpdateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Update Risk level';
  @Input() tempSkill: SkillUpdateCommand = {id: 0, name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @Input() show = false;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() updateCompleted = new EventEmitter<boolean>();
  showAlert = false;

  constructor(private serviceCommand: SkillCommandService) { }

  ngOnInit() {

  }

   showModal(tempSkill: SkillUpdateCommand): void {
     this.tempSkill = tempSkill;
     this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.isOkLoading = true;

      this.serviceCommand.update(this.tempSkill)
      .subscribe(result => {
        this.showAlert = true;

        this.alert.success('Success');
        this.resetTempSkill();
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

  resetTempSkill() {
    this.tempSkill = {id: 0, name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
    this.showAlert = false;
  }

}
