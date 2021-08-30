import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeerReviewFormComponent } from './beer-review-form.component';

describe('FavoriteBeerFormComponent', () => {
  let component: BeerReviewFormComponent;
  let fixture: ComponentFixture<BeerReviewFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeerReviewFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BeerReviewFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
