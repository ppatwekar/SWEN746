import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmittorPaperReviewComponent } from './submittor-paper-review.component';

describe('SubmittorPaperReviewComponent', () => {
  let component: SubmittorPaperReviewComponent;
  let fixture: ComponentFixture<SubmittorPaperReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubmittorPaperReviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubmittorPaperReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
