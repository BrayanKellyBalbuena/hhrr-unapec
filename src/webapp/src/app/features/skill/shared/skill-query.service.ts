import { Injectable } from '@angular/core';
import { SkillQuery } from './skill-query';
import { HttpClient, HttpParams } from '@angular/common/http';
import { endPoints, environment } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';
import { SkillWithIdName } from './skill-with-id-name';
import { PageRequest } from '../../../core/models/page-request';
import { Observable } from 'rxjs';
import { PageResponse } from '../../../core/models/page-response';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';

@Injectable({
  providedIn: 'root'
})
export class SkillQueryService extends CatalogQueryService<SkillQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.skills,
      httpClient
    );
  }

  public getWithIdName(pageRequest: PageRequest): Observable<PageResponse<CatalogWithIdAndNameQuery>> {
    return super.getWithIdName(pageRequest, endPoints.skills_with_id_name);
  }
}
