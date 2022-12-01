import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmittorSubmitComponent } from './submittor-submit.component';

describe('SubmittorSubmitComponent', () => {
  let component: SubmittorSubmitComponent;
  let fixture: ComponentFixture<SubmittorSubmitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubmittorSubmitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubmittorSubmitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
