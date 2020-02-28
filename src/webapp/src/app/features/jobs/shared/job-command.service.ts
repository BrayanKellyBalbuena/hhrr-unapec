import { Injectable } from '@angular/core';
import { CatalogCommandService } from '../../../core/services/catalog-command.service';
import { JobUpdateCommand } from './job-update-command';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { JobCreateCommand } from './job-create-command';

@Injectable({
  providedIn: 'root'
})
export class JobCommandService extends CatalogCommandService<JobCreateCommand,
  JobUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.jobs, httpClient);
  }
}
