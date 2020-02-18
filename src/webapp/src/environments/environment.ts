// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  host: 'http://localhost:',
  port: '8080',
  api: '/api/'

};

export const endPoints = {
  languages:  environment.host + environment.port + environment.api + 'languages/',
  riskLevels:  environment.host + environment.port + environment.api + 'risk_levels/',
  skills:  environment.host + environment.port + environment.api + 'skills/',
  skills_with_id_name:  environment.host + environment.port + environment.api + 'skills/skill_with_id_name/',
  riskLevelWithIdAndName:  environment.host + environment.port + environment.api + 'risk_levels/risk_level_with_id_name/',
  institutions: environment.host + environment.port + environment.api + 'institutions/',
  jobs: environment.host + environment.port + environment.api + 'jobs/'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
