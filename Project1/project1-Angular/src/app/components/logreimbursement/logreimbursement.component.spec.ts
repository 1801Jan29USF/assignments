import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogreimbursementComponent } from './logreimbursement.component';

describe('LogreimbursementComponent', () => {
  let component: LogreimbursementComponent;
  let fixture: ComponentFixture<LogreimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogreimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogreimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
