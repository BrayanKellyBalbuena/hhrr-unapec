import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommandService } from './command-service';
import { Observable } from 'rxjs';
import { BaseCreateCommand } from '../models/base-create-command';
import { BaseUpdateCommand } from '../models/base-update-command';

@Injectable({
  providedIn: 'root'
})
export abstract class BaseCommandService <TCreateCommand extends BaseCreateCommand,
  TUpdateCommand extends BaseUpdateCommand> implements CommandService<TCreateCommand, TUpdateCommand > {

  protected readonly headers = new HttpHeaders().set('Content-type', 'application/json');
  protected endPoint: string;
  protected httpClient: HttpClient;

  constructor(endPoint: string,  httpClient: HttpClient) {
    this.endPoint = endPoint;
    this.httpClient = httpClient;
  }

  create(command: TCreateCommand): Observable<void> {
    return this.httpClient.post<void>(this.endPoint, command, {headers: this.headers});
  }

  update(command: TUpdateCommand): Observable<void> {
    return this.httpClient.put<void>(this.endPoint + command.id, command, {headers: this.headers});
  }

  delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(this.endPoint + id, {headers: this.headers});

  }
}
