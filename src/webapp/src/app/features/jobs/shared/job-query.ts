import { BaseQuery } from '../../../core/models/base-query';
import { CatalogQuery } from '../../../core/models/catalog-query';
import { Job } from '../../../core/models/job';

export class JobQuery implements CatalogQuery {
  name: string;
  description: string;
  version: number;
  id: number;
  riskLevelId: number;
  riskLevelName: string;
  mininumSalary: number;
  maximunSalary: number;
  numberOfApplications: number;
}
