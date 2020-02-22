import { Injectable } from '@angular/core';
import { CandidateCreateCommand } from './candidate-create-command';
import { HttpClient } from '@angular/common/http';
import { CandidateUpdateCommand } from './candidate-update-command';
import { BaseCommandService } from '../../../core/services/base-command.service';
import { environment, endPoints } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CandidateCommandService  extends BaseCommandService<CandidateCreateCommand, CandidateUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.candidates, httpClient);
  }

}
