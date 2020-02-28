import { BaseUpdateCommand } from '../../../core/models/base-update-command';
import { BaseQuery } from '../../../core/models/base-query';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';

export interface SkillWithIdName extends CatalogWithIdAndNameQuery{
  name: string;
}
