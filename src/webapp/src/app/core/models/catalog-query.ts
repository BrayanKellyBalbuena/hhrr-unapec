import { BaseQuery } from './base-query';

export interface CatalogQuery extends BaseQuery {
  name: string;
  description: string;
}
