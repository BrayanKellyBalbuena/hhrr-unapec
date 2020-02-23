// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  host: 'http://localhost:',
  port: '8080',
  api: '/api/',
  auth: 'auth/'

};

export const endPoints = {
  languages:  environment.host + environment.port + environment.api + 'languages/',
  riskLevels:  environment.host + environment.port + environment.api + 'risk_levels/',
  skills:  environment.host + environment.port + environment.api + 'skills/',
  skills_with_id_name:  environment.host + environment.port + environment.api + 'skills/skill_with_id_name/',
  riskLevelWithIdAndName:  environment.host + environment.port + environment.api + 'risk_levels/risk_level_with_id_name/',
  institutions: environment.host + environment.port + environment.api + 'institutions/',
  institutionsWithIdAndName: environment.host + environment.port + environment.api + 'institutions/institutions_with_id_name',
  jobs: environment.host + environment.port + environment.api + 'jobs/',
  trainings: environment.host + environment.port + environment.api + 'trainings/',
  signin: environment.host + environment.port + environment.api + environment.auth + 'signin',
  candidates: environment.host + environment.port + environment.api  + 'candidates/',
  candidates_add_skills: environment.host + environment.port + environment.api  + 'candidates/add_skills/',
  candidateDeleteSkill: environment.host + environment.port + environment.api  + 'candidates/skills/',
  candidates_not_assign_skills: environment.host + environment.port + environment.api  + 'candidates/not_assign_skills/',
  candidatesGetSkills: environment.host + environment.port + environment.api  + 'candidates/get_skills/',
  candidatesGetLanguages: environment.host + environment.port + environment.api  + 'candidates/get_languages/',
  candidates_not_assign_languages: environment.host + environment.port + environment.api  + 'candidates/not_assign_languages/',
  candidates_add_languages: environment.host + environment.port + environment.api  + 'candidates/add_languages/',
  candidateDeleteLanguage: environment.host + environment.port + environment.api  + 'candidates/languages/',
  candidateJobApply: environment.host + environment.port + environment.api  + 'candidates/jobs/apply/',
  candidateJobs: environment.host + environment.port + environment.api  + 'candidates/jobs/',
  candidateNotApplieyJobs: environment.host + environment.port + environment.api  + 'candidates/jobs/no_apply',
  candidateTrainings: environment.host + environment.port + environment.api  + 'candidates/trainings/',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
