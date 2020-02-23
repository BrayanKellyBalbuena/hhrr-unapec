import { BaseQuery } from '../models/base-query';
import { Observable } from 'rxjs';
import { PageRequest } from '../models/page-request';
import { PageResponse } from '../models/page-response';
import { HttpParams } from '@angular/common/http';

export interface QueryService<TQuery extends BaseQuery> {
  getAll(pageRequest: PageRequest): Observable<PageResponse<TQuery>>;
  getById(id: number): Observable<TQuery>;
  getHttpParams(pageRequest: PageRequest): HttpParams;
}
