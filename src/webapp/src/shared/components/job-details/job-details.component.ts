import { Component, OnInit, Output, EventEmitter, ViewChild, Input } from '@angular/core';

import { NgForm } from '@angular/forms';
import { JobUpdateCommand } from '../../../app/features/jobs/shared/job-update-command';
import { CandidateCommandService } from '../../../app/features/candidate/shared/candidate-command.service';
import { JobQuery } from '../../../app/features/jobs/shared/job-query';



@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent {

  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Details Job';
  @Input() job: JobQuery;
  @Input() showApplyButton: false;
  @Output() OnApply = new EventEmitter<boolean>();
  @Input() show = false;

  constructor(private candidateCommnadService: CandidateCommandService) {
    this.job = new JobQuery();
   }


   showModal(job: JobQuery): void {
     this.job = job;
     this.isVisible = true;
  }

  applyToJob() {
    this.toggleIsOkLoading();
    this.candidateCommnadService.applyToJob(this.job.id)
    .subscribe(() => this.toggleIsOkLoading(),
    err => {console.log(err); this.toggleIsOkLoading()});
  }

  toggleIsOkLoading() {
    this.isOkLoading = !this.isOkLoading;
  }

  handleCancel(): void {
    this.isVisible = false;
  }


}
