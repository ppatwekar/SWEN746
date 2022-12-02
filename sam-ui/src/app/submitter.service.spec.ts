import { TestBed } from '@angular/core/testing';

import { SubmitterService } from './submitter.service';

describe('SubmitterService', () => {
  let service: SubmitterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubmitterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
