import { BaseQuery } from '../../../core/models/base-query';
import { Candidate } from '../../../core/models/candidate';

export class EmployeeQuery extends Candidate implements BaseQuery {
    id: number;
    version: number;
    hireDate: Date;
    salary: number;
}
