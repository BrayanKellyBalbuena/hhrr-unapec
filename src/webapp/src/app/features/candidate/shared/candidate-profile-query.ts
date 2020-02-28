import { Candidate } from '../../../core/models/candidate';
import { BaseQuery } from '../../../core/models/base-query';
import { TrainingQuery } from '../../training/shared/training-query';

export class CandidateProfileQuery extends Candidate implements BaseQuery {
  id: number;
  version: number;
  trainings: string[];
  skills: string[];
  laguages: string;
}
