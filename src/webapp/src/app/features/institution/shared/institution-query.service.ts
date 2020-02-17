import { Injectable } from '@angular/core';
import { InstitutionQuery } from './institution-query';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';

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
}
