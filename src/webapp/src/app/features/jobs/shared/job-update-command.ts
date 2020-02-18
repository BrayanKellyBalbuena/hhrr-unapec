import { CatalogUpdateCommand } from '../../../core/models/catalog-update-command';
import { Job } from '../../../core/models/job';

export class  JobUpdateCommand implements CatalogUpdateCommand, Job {
  version: number;
  riskLevelId: number;
  mininumSalary  = 0;
  maximunSalary = 0;
  name: string;
  description: string;
  id: number;

}
