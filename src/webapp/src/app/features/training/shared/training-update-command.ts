import { CatalogUpdateCommand } from '../../../core/models/catalog-update-command';
import { Training } from '../../../core/models/training';

export class TrainingUpdateCommand
extends Training implements CatalogUpdateCommand  {
  id: number;
  name = '';
  description: string;
  version: number;
}
