import { BaseUpdateCommand } from './base-update-command';

export interface CatalogUpdateCommand extends BaseUpdateCommand {
  name: string;
  description: string;
}
