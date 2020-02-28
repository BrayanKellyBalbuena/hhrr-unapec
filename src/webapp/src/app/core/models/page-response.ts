import { BaseQuery } from './base-query';
import { BaseModel } from './base-model';

export interface PageResponse<TQuery extends BaseModel> {
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


