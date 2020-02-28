import { Injectable } from '@angular/core';
import { BaseCommandService } from './base-command.service';

import { HttpClient } from '@angular/common/http';
import { BaseCreateCommand } from '../models/base-create-command';
import { BaseUpdateCommand } from '../models/base-update-command';

@Injectable({
  providedIn: 'root'
})
export abstract class CatalogCommandService<TCreateCommand extends BaseCreateCommand,
 TUpdateCommand extends BaseUpdateCommand> extends BaseCommandService<TCreateCommand, TUpdateCommand> {
  constructor(endPoint: string, protected httpClient: HttpClient) {
    super(endPoint, httpClient);
  }
}
