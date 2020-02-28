import { BaseCreateCommand } from '../../../core/models/base-create-command';
import { Candidate } from '../../../core/models/candidate';

export class CandidateCreateCommand extends Candidate implements BaseCreateCommand {
  firstName: string;
  lastName: string;
  age: number;
  email: string;
  identityCard: string;
  password: string;
  userName: string;
}
