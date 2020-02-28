import { CandidateCreateCommand } from './candidate-create-command';
import { BaseUpdateCommand } from '../../../core/models/base-update-command';

export class CandidateUpdateCommand extends CandidateCreateCommand implements BaseUpdateCommand {
  version: number;  id: number;
}
