import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoriteBeerFormComponent } from './favorite-beer-form.component';

describe('FavoriteBeerFormComponent', () => {
  let component: FavoriteBeerFormComponent;
  let fixture: ComponentFixture<FavoriteBeerFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FavoriteBeerFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FavoriteBeerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
