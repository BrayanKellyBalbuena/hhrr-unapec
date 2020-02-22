import { BaseCreateCommand } from '../../../core/models/base-create-command';

export class CandidateCreateCommand implements BaseCreateCommand {
  firstName: string;
  lastName: string;
  age: number;
  email: string;
  identityCard: string;
  password: string;
  userName: string;
}
