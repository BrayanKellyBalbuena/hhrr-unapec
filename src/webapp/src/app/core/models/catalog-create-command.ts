import { BaseCreateCommand } from './base-create-command';

export interface CatalogCreateCommand extends BaseCreateCommand{
  name: string;
  description: string;
}
