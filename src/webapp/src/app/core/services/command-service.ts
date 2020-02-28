import { Observable } from 'rxjs';
import { BaseCreateCommand } from '../models/base-create-command';
import { BaseUpdateCommand } from '../models/base-update-command';


export interface CommandService<TCreateCommand extends BaseCreateCommand,
TUpdateCommand extends BaseUpdateCommand> {
  create(command: TCreateCommand): Observable<void>;
  update(command: TUpdateCommand): Observable<void>;
  delete(id: number): Observable<void>;
}
