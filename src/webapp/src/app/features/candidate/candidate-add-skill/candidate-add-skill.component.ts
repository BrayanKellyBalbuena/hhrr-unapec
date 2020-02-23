import { Component, OnInit, Output, ViewChild, EventEmitter } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MessageTitle } from '../../../core/enums/message-title.enum';
import { NgForm } from '@angular/forms';
import { SkillCommandService } from '../../skill/shared/skill-command.service';
import { SkillCreateCommand } from '../../skill/shared/skill-create-command';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { SkillQueryService } from '../../skill/shared/skill-query.service';
import { SkillWithIdName } from '../../skill/shared/skill-with-id-name';
import { PageRequest } from '../../../core/models/page-request';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';

@Component({
  selector: 'app-candidate-add-skill',
  templateUrl: './candidate-add-skill.component.html',
  styleUrls: ['./candidate-add-skill.component.css']
})
export class CandidateAddSkillComponent implements OnInit {
  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Add new Skill';
  tempSkill: SkillCreateCommand = {name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;
  listOfOption: CatalogWithIdAndNameQuery[];
  listOfSelectedValue: CatalogWithIdAndNameQuery[];

  constructor(private serviceCommand: SkillCommandService, private queryService: SkillQueryService) { }

  ngOnInit() {
    this.loadSkills();
  }

   showModal(): void {
    this.isVisible = true;
  }

  loadSkills() {
    this.queryService.getAllCandidateNoAssingSkill(PageRequest.init( 50, 1))
    .subscribe(data => { this.listOfOption = data.content; console.log(data)},
      err => console.log(err));
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.toggleIsOkLoading();
      this.serviceCommand.candidateAddSkills(this.listOfSelectedValue)
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
