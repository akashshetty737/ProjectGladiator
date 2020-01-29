import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmiPaymentComponent } from './emi-payment.component';

describe('EmiPaymentComponent', () => {
  let component: EmiPaymentComponent;
  let fixture: ComponentFixture<EmiPaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmiPaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmiPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
