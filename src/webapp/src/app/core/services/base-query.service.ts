import { Injectable } from '@angular/core';
import { BaseQuery } from '../models/base-query';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { QueryService } from './query-service';
import { Observable } from 'rxjs';
import { PageRequest } from '../models/page-request';
import { PageResponse } from '../models/page-response';

@Injectable({
  providedIn: 'root'
})
export abstract class BaseQueryService<TQuery extends BaseQuery> implements QueryService<TQuery> {

  protected query: TQuery;
  protected readonly headers = new HttpHeaders().set('Content-type', 'application/json');
  protected endPoint: string;
  protected httpClient: HttpClient;

  constructor(endPoint: string,  httpClient: HttpClient) {
    this.endPoint = endPoint;
    this.httpClient = httpClient;
  }

  getHttpParams(pageRequest: PageRequest): HttpParams {
    const requesParams = new HttpParams()
    .set('pageNumber', pageRequest.pageNumber.toString())
    .set('pageSize', pageRequest.pageSize.toString())
    .set('sortDirection', pageRequest.sortDirection)
    .set('sortField', pageRequest.sortField);

    return requesParams;

  }

  getAll(pageRequest: PageRequest): Observable<PageResponse<TQuery>> {
    const requesParams = this.getHttpParams(pageRequest);

    return this.httpClient.get<PageResponse<TQuery>>(this.endPoint, {headers: this.headers, params: requesParams});

  }

  getById(id: number): Observable<TQuery> {
    return this.httpClient.get<TQuery>(this.endPoint + id, {headers: this.headers});
  }
}
