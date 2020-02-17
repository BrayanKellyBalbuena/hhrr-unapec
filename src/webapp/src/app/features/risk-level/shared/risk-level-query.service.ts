import { Injectable } from '@angular/core';
import { BaseQueryService } from '../../../core/services/base-query.service';
import { RiskLevelQuery } from './risk-level-query';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';

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
}
