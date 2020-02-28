import { Injectable } from '@angular/core';
import { CatalogCommandService } from '../../../core/services/catalog-command.service';
import { InstitutionUpdateCommand } from './institution-update-command';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { InstitutionCreateCommand } from './institution-create-command';

@Injectable({
  providedIn: 'root'
})
export class InstitutionCommandService extends CatalogCommandService<InstitutionCreateCommand,
  InstitutionUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.institutions, httpClient);
  }
}
