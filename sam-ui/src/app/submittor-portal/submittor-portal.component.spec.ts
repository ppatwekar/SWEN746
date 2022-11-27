import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmittorPortalComponent } from './submittor-portal.component';

describe('SubmittorPortalComponent', () => {
  let component: SubmittorPortalComponent;
  let fixture: ComponentFixture<SubmittorPortalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubmittorPortalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubmittorPortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
