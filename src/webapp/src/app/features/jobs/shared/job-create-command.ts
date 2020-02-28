import { CatalogCreateCommand } from '../../../core/models/catalog-create-command';
import { Job } from '../../../core/models/job';

export class JobCreateCommand implements CatalogCreateCommand, Job {
  name: string;
  description: string;
  riskLevelId: number;
  mininumSalary = 0.00;
  maximunSalary = 0.00;
}
