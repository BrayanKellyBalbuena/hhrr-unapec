import { Injectable } from '@angular/core';
import { CatalogCommandService } from '../../../core/services/catalog-command.service';
import { TrainingUpdateCommand } from './training-update-command';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { TrainingCreateCommand } from './training-create-command';

@Injectable({
  providedIn: 'root'
})
export class TrainingCommandService extends CatalogCommandService<TrainingCreateCommand,
  TrainingUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.trainings, httpClient);
  }
}
