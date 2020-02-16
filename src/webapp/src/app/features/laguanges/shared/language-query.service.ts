import { Injectable } from '@angular/core';
import { BaseQueryService } from '../../../core/services/base-query.service';
import { LanguageQuery } from './language-query';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';

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
}
