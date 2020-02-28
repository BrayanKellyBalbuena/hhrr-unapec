import { Injectable } from '@angular/core';
import { InstitutionQuery } from './institution-query';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';
import { PageRequest } from '../../../core/models/page-request';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';
import { Observable } from 'rxjs';
import { PageResponse } from '../../../core/models/page-response';

@Injectable({
  providedIn: 'root'
})
export class InstitutionQueryService extends CatalogQueryService<InstitutionQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.institutions,
      httpClient
    );
  }

  public getWithIdName(pageRequest: PageRequest): Observable<PageResponse<CatalogWithIdAndNameQuery>> {
    return super.getWithIdName(pageRequest, endPoints.institutionsWithIdAndName);
  }
}
