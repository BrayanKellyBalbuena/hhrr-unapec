import { Injectable } from '@angular/core';
import { CatalogCommandService } from '../../../core/services/catalog-command.service';
import { RiskLevelUpdateCommand } from './risk-level-update-command';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { RiskLevelCreateCommand } from './risk-level-create-command';

@Injectable({
  providedIn: 'root'
})
export class RiskLevelCommandService extends CatalogCommandService<RiskLevelCreateCommand,
  RiskLevelUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.riskLevels, httpClient);
  }
}
