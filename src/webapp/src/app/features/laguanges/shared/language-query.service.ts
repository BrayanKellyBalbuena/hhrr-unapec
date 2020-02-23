import { Injectable } from '@angular/core';
import { BaseQueryService } from '../../../core/services/base-query.service';
import { LanguageQuery } from './language-query';
import { HttpClient, HttpParams } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';
import { PageRequest } from '../../../core/models/page-request';
import { PageResponse } from '../../../core/models/page-response';
import { Observable } from 'rxjs';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';

@Injectable({
  providedIn: 'root'
})
export class LanguageQueryService extends CatalogQueryService<LanguageQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.languages,
      httpClient
    );
  }

  getAllCandidateNoAssingLanguage(pageRequest: PageRequest): Observable<PageResponse<CatalogWithIdAndNameQuery>> {
    const requesParams = new HttpParams()
    .set('pageNumber', pageRequest.pageNumber.toString())
    .set('pageSize', pageRequest.pageSize.toString())
    .set('sortDirection', pageRequest.sortDirection)
    .set('sortField', pageRequest.sortField);

    return this.httpClient.get<PageResponse<CatalogWithIdAndNameQuery>>(endPoints.candidates_not_assign_languages,
       {headers: this.headers, params: requesParams});

  }

  getCandidatesLanguage(pageRequest: PageRequest): Observable<PageResponse<LanguageQuery>> {
    const requesParams = new HttpParams()
    .set('pageNumber', pageRequest.pageNumber.toString())
    .set('pageSize', pageRequest.pageSize.toString())
    .set('sortDirection', pageRequest.sortDirection)
    .set('sortField', pageRequest.sortField);

    return this.httpClient.get<PageResponse<LanguageQuery>>(endPoints.candidatesGetLanguages,
       {headers: this.headers, params: requesParams});
  }
}
