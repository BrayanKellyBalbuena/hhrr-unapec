import { Injectable } from '@angular/core';
import { RiskLevelQuery } from './risk-level-query';
import { HttpClient, HttpParams } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';
import { Observable } from 'rxjs';
import { PageRequest } from '../../../core/models/page-request';
import { PageResponse } from '../../../core/models/page-response';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';

@Injectable({
  providedIn: 'root'
})
export class RiskLevelQueryService extends CatalogQueryService<RiskLevelQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.riskLevels,
      httpClient
    );
  }

  public getWithIdName(pageRequest: PageRequest): Observable<PageResponse<CatalogWithIdAndNameQuery>> {
    return super.getWithIdName(pageRequest, endPoints.riskLevelWithIdAndName);
  }
}
