import { BaseQuery } from '../../../core/models/base-query';
import { CatalogQuery } from '../../../core/models/catalog-query';
import { Job } from '../../../core/models/job';

export interface JobQuery extends CatalogQuery {
  riskLevelId: number;
  riskLevel: string;
  mininumSalary: number;
  maximunSalary: number;
}
