import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { BaseQuery } from "../models/base-query";
import { CatalogQuery } from "../models/catalog-query";
import { BaseQueryService } from "./base-query.service";
import { Observable } from "rxjs";
import { PageRequest } from "../models/page-request";
import { CatalogSeachField } from "../enums/catalog-seach-field.enum";
import { PageResponse } from "../models/page-response";
import { CatalogWithIdAndNameQuery } from "../models/CatalogWithIdAndNameQuery";

@Injectable({
  providedIn: "root"
})
export abstract class CatalogQueryService<
  TQuery extends CatalogQuery
> extends BaseQueryService<TQuery> {
  protected endPoint: string;

  constructor(endPoint: string, protected httpClient: HttpClient) {
    super(endPoint, httpClient);
  }

  getByName(
    name: string,
    pageRequest: PageRequest
  ): Observable<PageResponse<TQuery>> {
    const requesParams = this.getHttpParams(pageRequest)
      .set('searchBy', CatalogSeachField.NAME)
      .set('seachCriteria', name);

    return this.httpClient.get<PageResponse<TQuery>>(
      this.endPoint + 'searchBy/',
      { headers: this.headers, params: requesParams }
    );
  }

  getByDescription(
    description: string,
    pageRequest: PageRequest
  ): Observable<PageResponse<TQuery>> {
    const requesParams = this.getHttpParams(pageRequest)
      .set('searchBy', CatalogSeachField.DESCRIPTION)
      .set('seachCriteria', description);

    return this.httpClient.get<PageResponse<TQuery>>(
      this.endPoint + 'searchBy/',
      { headers: this.headers, params: requesParams }
    );
  }

  public getWithIdName(
    pageRequest: PageRequest,
    endPoint: string
  ): Observable<PageResponse<CatalogWithIdAndNameQuery>> {
    const requesParams = this.getHttpParams(pageRequest);

    return this.httpClient.get<PageResponse<CatalogWithIdAndNameQuery>>(
      endPoint,
      { headers: this.headers, params: requesParams }
    );
  }
}
