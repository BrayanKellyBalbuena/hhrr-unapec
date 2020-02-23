import { Injectable } from '@angular/core';
import { CatalogCommandService } from '../../../core/services/catalog-command.service';
import { LanguageUpdateCommand } from './language-update-command';
import { LanguageCreateCommand } from './language-create-command';
import { HttpClient } from '@angular/common/http';
import { endPoints } from '../../../../environments/environment';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';

@Injectable({
  providedIn: 'root'
})
export class LanguageCommandService extends CatalogCommandService<LanguageCreateCommand,
  LanguageUpdateCommand> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.languages, httpClient);
  }

  candidateAddLanguages(language: CatalogWithIdAndNameQuery[]) {
    return this.httpClient.post(endPoints.candidates_add_languages, language);
  }

  deleteCandidateLanguage(id: number) {
    return this.httpClient.delete(endPoints.candidateDeleteLanguage + id);
  }
}
