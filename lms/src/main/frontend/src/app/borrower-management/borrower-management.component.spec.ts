import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrowerManagementComponent } from './borrower-management.component';

describe('BorrowerManagementComponent', () => {
  let component: BorrowerManagementComponent;
  let fixture: ComponentFixture<BorrowerManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BorrowerManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrowerManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
