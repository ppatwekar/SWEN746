import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarSubmittorComponent } from './navbar-submittor.component';

describe('NavbarSubmittorComponent', () => {
  let component: NavbarSubmittorComponent;
  let fixture: ComponentFixture<NavbarSubmittorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarSubmittorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarSubmittorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
