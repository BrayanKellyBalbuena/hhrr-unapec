import { Injectable } from '@angular/core';
import { BaseQueryService } from '../../../core/services/base-query.service';
import { CandidateQuery } from './candidate-query';
import { endPoints } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PageResponse } from '../../../core/models/page-response';
import { JobQuery } from '../../jobs/shared/job-query';
import { PageRequest } from '../../../core/models/page-request';
import { TrainingQuery } from '../../training/shared/training-query';

@Injectable({
  providedIn: 'root'
})
export class CandidateQueryService extends BaseQueryService<CandidateQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.candidates,
      httpClient
    );
  }

}
