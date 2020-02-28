import { Injectable } from "@angular/core";
import { CatalogCommandService } from "../../../core/services/catalog-command.service";
import { SkillUpdateCommand } from "./skill-update-command";
import { HttpClient, HttpParams } from "@angular/common/http";
import { endPoints } from "../../../../environments/environment";
import { SkillCreateCommand } from "./skill-create-command";
import { SkillWithIdName } from "./skill-with-id-name";
import { CatalogWithIdAndNameQuery } from "../../../core/models/CatalogWithIdAndNameQuery";
import { PageRequest } from "../../../core/models/page-request";
import { Observable } from "rxjs";
import { PageResponse } from "../../../core/models/page-response";

@Injectable({
  providedIn: "root"
})
export class SkillCommandService extends CatalogCommandService<
  SkillCreateCommand,
  SkillUpdateCommand
> {
  constructor(protected httpClient: HttpClient) {
    super(endPoints.skills, httpClient);
  }

  candidateAddSkills(skill: CatalogWithIdAndNameQuery[]) {
    return this.httpClient.post(endPoints.candidates_add_skills, skill);
  }

  deleteCandidateSkill(id: number) {
    return this.httpClient.delete(endPoints.candidateDeleteSkill + id);
  }
}
