import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';

import { NgForm } from '@angular/forms';
import { JobUpdateCommand } from '../../../app/features/jobs/shared/job-update-command';
import { CandidateCommandService } from '../../../app/features/candidate/shared/candidate-command.service';
import { JobQuery } from '../../../app/features/jobs/shared/job-query';
import { CandidateQuery } from '../../../app/features/candidate/shared/candidate-query';
import { LanguageQueryService } from '../../../app/features/laguanges/shared/language-query.service';
import { SkillQueryService } from '../../../app/features/skill/shared/skill-query.service';
import { TrainingQueryService } from '../../../app/features/training/shared/training-query.service';
import { NzMessageService } from 'ng-zorro-antd';
import { PageRequest } from '../../../app/core/models/page-request';
import { HttpErrorResponse } from '@angular/common/http';
import { TrainingQuery } from '../../../app/features/training/shared/training-query';
import { SkillQuery } from '../../../app/features/skill/shared/skill-query';
import { LanguageQuery } from '../../../app/features/laguanges/shared/language-query';



@Component({
  selector: 'app-candidate-profile',
  templateUrl: './candidate-profile.component.html',
  styleUrls: ['./candidate-profile.component.css']
})
export class CandidateProfileComponent implements OnInit {

  languages: LanguageQuery[];
  skills: SkillQuery[];
  trainings: TrainingQuery[];
  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Candidate Profile';
  @Input() candidate: CandidateQuery;
  @Input() showContractButton: false;
  @Output() OnApply = new EventEmitter<boolean>();
  @Input() show = false;
  isConfirmLoading = false;

  constructor(private candidateCommnadService: CandidateCommandService,
              private languageQueryService: LanguageQueryService,
              private skillQueryService: SkillQueryService,
              private trainingQueryService: TrainingQueryService,
              private messageService: NzMessageService ) {
    this.candidate = new CandidateQuery();
   }

   ngOnInit() {

   }

   showModal(candidate: CandidateQuery): void {
     this.candidate = candidate;
     this.isVisible = true;
     this.loadLanguages(PageRequest.init(20, 1));
     this.loadTrainings(PageRequest.init(20, 1));
     this.loadSkills(PageRequest.init(20, 1));
  }

  loadSkills(pageRequest: PageRequest) {
    this.skillQueryService.getCandidateSkillsById(this.candidate.id, pageRequest)
    .subscribe(
      data => this.skills = data.content,
      (err: HttpErrorResponse) => this.messageService.error(err.error['message'])
    );
  }
  loadTrainings(pageRequest: PageRequest) {
    this.trainingQueryService.getTrainingsByCandidateId(this.candidate.id, pageRequest)
    .subscribe(
      data => this.trainings = data.content,
      (err: HttpErrorResponse) => this.messageService.error(err.error['message'])
    );
  }
  loadLanguages(pageRequest: PageRequest) {
    this.languageQueryService.getLanguagesByCandidateId(this.candidate.id, pageRequest)
    .subscribe(
      data => this.languages = data.content,
      (err: HttpErrorResponse) => this.messageService.error(err.error['message'])
    );
  }

  contract(candidateId: number) {
    this.toggleIsOkLoading();
    this.candidateCommnadService.contract(this.candidate.id) /*Change for converto to employee*/
    .subscribe(() => {
      this.messageService.success('Employee contract succes') ;
      this.toggleIsOkLoading();
      this.candidate.isEmployee = true;
    },
    (err: HttpErrorResponse) => {this.messageService.error(err.error['message']); this.toggleIsOkLoading()});
  }

  toggleIsOkLoading() {
    this.isOkLoading = !this.isOkLoading;
  }

  handleCancel(): void {
    this.isVisible = false;
  }


}
