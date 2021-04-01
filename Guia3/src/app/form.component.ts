import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class FormComponent implements OnInit {

    myForm: FormGroup;

    constructor(
        public fb: FormBuilder
    ) {
      this.myForm=this.fb.group({
        autor: ['', [Validators.required]],
        usuario: ['', [Validators.required]],
        twitter: ['', [Validators.required]],
        facebook: ['', [Validators.required]],
        instagram: ['', [Validators.required]],
        descripcion: ['', [Validators.required]],
      });
    }
    ngOnInit() { }
    saveData() {
        console.log(this.myForm.value);
    }

}