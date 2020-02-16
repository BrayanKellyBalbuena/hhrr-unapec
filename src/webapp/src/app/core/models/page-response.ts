import { BaseQuery } from './base-query';

export interface PageResponse<TQuery extends BaseQuery> {
  content: TQuery[];
  totalElements: number;
  last: boolean;
  totalPages: number;
  size: number;
  number: number;
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}


