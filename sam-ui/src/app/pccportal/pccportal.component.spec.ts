import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PCCPortalComponent } from './pccportal.component';

describe('PCCPortalComponent', () => {
  let component: PCCPortalComponent;
  let fixture: ComponentFixture<PCCPortalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PCCPortalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PCCPortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
