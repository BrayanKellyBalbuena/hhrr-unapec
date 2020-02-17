import { Injectable } from '@angular/core';
import { CatalogCommandService } from '../../../core/services/catalog-command.service';
import { SkillUpdateCommand } from './skill-update-command';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { SkillCreateCommand } from './skill-create-command';

@Injectable({
  providedIn: 'root'
})
export class SkillCommandService extends CatalogCommandService<SkillCreateCommand,
  SkillUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.skills, httpClient);
  }
}
