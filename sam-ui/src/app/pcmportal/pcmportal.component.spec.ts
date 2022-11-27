import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PCMPortalComponent } from './pcmportal.component';

describe('PCMPortalComponent', () => {
  let component: PCMPortalComponent;
  let fixture: ComponentFixture<PCMPortalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PCMPortalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PCMPortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
