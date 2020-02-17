import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { SkillCreateCommand } from '../shared/skill-create-command';
import { SkillCommandService } from '../shared/skill-command.service';
import { MessageTitle } from '../../../core/enums/message-title.enum';

@Component({
  selector: 'app-skill-create',
  templateUrl: './skill-create.component.html',
  styleUrls: ['./skill-create.component.css']
})
export class SkillCreateComponent implements OnInit {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Create new Skill';
  tempSkill: SkillCreateCommand = {name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;

  constructor(private serviceCommand: SkillCommandService) { }

  ngOnInit() {
    this.serviceCommand.create(this.tempSkill);
  }

   showModal(): void {
    this.isVisible = true;
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.toggleIsOkLoading();
      this.serviceCommand.create(this.tempSkill)
      .subscribe(() => {
        this.showAlert = true;
        this.alert.success(MessageTitle.SUCCESS);
        this.resetTempSkill();
        form.reset();
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

  resetTempSkill() {
    this.tempSkill = {name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
  }

}
