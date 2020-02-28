import { CatalogQuery } from '../../../core/models/catalog-query';
import { Training } from '../../../core/models/training';

export class TrainingQuery extends Training implements CatalogQuery {
  name: string;
  description: string;
  version: number;
  id: number;
  institutionName: string;
}
