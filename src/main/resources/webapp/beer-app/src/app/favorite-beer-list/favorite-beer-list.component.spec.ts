import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoriteBeerListComponent } from './favorite-beer-list.component';

describe('FavoriteBeerListComponent', () => {
  let component: FavoriteBeerListComponent;
  let fixture: ComponentFixture<FavoriteBeerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FavoriteBeerListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FavoriteBeerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
