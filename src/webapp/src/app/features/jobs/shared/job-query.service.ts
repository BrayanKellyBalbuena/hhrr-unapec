import { Injectable } from '@angular/core';
import { BaseQueryService } from '../../../core/services/base-query.service';
import { JobQuery } from './job-query';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';
import { Observable } from 'rxjs';
import { PageResponse } from '../../../core/models/page-response';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';
import { PageRequest } from '../../../core/models/page-request';

@Injectable({
  providedIn: 'root'
})
export class JobQueryService extends CatalogQueryService<JobQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.jobs,
      httpClient
    );
  }

  public getCandidateJobs(pageRequest: PageRequest): Observable<PageResponse<JobQuery>> {
    return this.httpClient.get<PageResponse<JobQuery>>(endPoints.candidateJobs,
       {headers: this.headers, params: this.getHttpParams(pageRequest)});
  }

  public getCandidateNoApplyJobs(pageRequest: PageRequest): Observable<PageResponse<JobQuery>> {
    return this.httpClient.get<PageResponse<JobQuery>>(endPoints.candidateNotApplieyJobs,
      {headers: this.headers, params: this.getHttpParams(pageRequest)});
  }

}
