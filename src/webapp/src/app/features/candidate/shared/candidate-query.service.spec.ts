/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CandidateQueryService } from './candidate-query.service';

describe('Service: CandidateQuery', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CandidateQueryService]
    });
  });

  it('should ...', inject([CandidateQueryService], (service: CandidateQueryService) => {
    expect(service).toBeTruthy();
  }));
});
