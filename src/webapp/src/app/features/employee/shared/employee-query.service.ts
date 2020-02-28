import { Injectable } from '@angular/core';
import { EmployeeQuery } from './employee-query';
import { BaseQueryService } from '../../../core/services/base-query.service';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeQueryService  extends BaseQueryService<EmployeeQuery> {

  constructor(protected httpClient: HttpClient) {
    super(endPoints.employees, httpClient);
  }
}
