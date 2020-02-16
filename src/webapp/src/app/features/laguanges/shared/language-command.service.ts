import { Injectable } from '@angular/core';
import { CatalogCommandService } from '../../../core/services/catalog-command.service';
import { LanguageUpdateCommand } from './language-update-command';
import { LanguageCreateCommand } from './language-create-command';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LanguageCommandService extends CatalogCommandService<LanguageCreateCommand,
  LanguageUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.languages, httpClient);
  }
}
