import { BaseQuery } from '../../../core/models/base-query';
import { Candidate } from '../../../core/models/candidate';

export class CandidateQuery extends Candidate implements BaseQuery {
  version: number;
  id: number;

}
