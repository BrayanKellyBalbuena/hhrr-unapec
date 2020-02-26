import { Injectable } from '@angular/core';
import { CandidateCreateCommand } from './candidate-create-command';
import { HttpClient } from '@angular/common/http';
import { CandidateUpdateCommand } from './candidate-update-command';
import { BaseCommandService } from '../../../core/services/base-command.service';
import { environment, endPoints } from '../../../../environments/environment';
import { JobUpdateCommand } from '../../jobs/shared/job-update-command';

@Injectable({
  providedIn: 'root'
})
export class CandidateCommandService  extends BaseCommandService<CandidateCreateCommand, CandidateUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.candidates, httpClient);
  }

  public applyToJob(jobId: number) {
    return this.httpClient.post(endPoints.candidateJobApply + jobId, {});
  }

  public contract(candidateId: number) {
    return this.httpClient.post(endPoints.candidateContract.replace('{id}', candidateId.toString()) , {});
  }
}
