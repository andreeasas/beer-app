import { TestBed } from '@angular/core/testing';

import { FavoriteBeerService } from './favorite-beer.service';

describe('FavoriteBeerService', () => {
  let service: FavoriteBeerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FavoriteBeerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
