import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallesAutorComponent } from './detalles-autor.component';

describe('DetallesAutorComponent', () => {
  let component: DetallesAutorComponent;
  let fixture: ComponentFixture<DetallesAutorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetallesAutorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetallesAutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
