import { BaseModel } from './base-model';

export interface BaseUpdateCommand extends BaseModel {
  version: number;
}
