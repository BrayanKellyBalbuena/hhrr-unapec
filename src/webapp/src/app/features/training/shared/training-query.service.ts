import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogQueryService } from '../../../core/services/catalog-query.service';
import { TrainingQuery } from '../../training/shared/training-query';

@Injectable({
  providedIn: 'root'
})
export class TrainingQueryService extends CatalogQueryService<TrainingQuery> {

  constructor(protected httpClient: HttpClient) {
    super(
      endPoints.trainings,
      httpClient
    );
  }

}
