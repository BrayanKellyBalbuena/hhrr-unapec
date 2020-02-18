import { CatalogUpdateCommand } from '../../../core/models/catalog-update-command';

export class SkillUpdateCommand implements CatalogUpdateCommand {
  name: string;  description: string;
  version: number;
  id: number;

}
