import { TestBed } from '@angular/core/testing';

import { UserGoalService,} from './usergoal.service';

describe('UserService', () => {
  let service: UserGoalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserGoalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
