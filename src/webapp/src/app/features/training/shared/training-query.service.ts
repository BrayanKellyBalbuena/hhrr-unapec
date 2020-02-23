import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';
import { TrainingQuery } from '../../training/shared/training-query';
import { PageRequest } from '../../../core/models/page-request';
import { Observable } from 'rxjs';
import { PageResponse } from '../../../core/models/page-response';

@Injectable({
  providedIn: 'root'
})
export class TrainingQueryService extends CatalogQueryService<TrainingQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.trainings,
      httpClient
    );
  }

  public getByCandidateId(pageRequest: PageRequest): Observable<PageResponse<TrainingQuery>> {
    return this.httpClient.get<PageResponse<TrainingQuery>>(endPoints.candidateTrainings,
       {headers: this.headers, params: this.getHttpParams(pageRequest)});
  }

}
