import { Injectable } from '@angular/core';
import { SkillQuery } from './skill-query';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';

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
}
