import { CatalogCreateCommand } from '../../../core/models/catalog-create-command';
import { Training } from '../../../core/models/training';

export class TrainingCreateCommand extends Training implements CatalogCreateCommand {
  description: string;
  name: string;
}
