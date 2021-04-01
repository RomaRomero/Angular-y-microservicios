import { Component, OnInit } from '@angular/core';
import { Autor } from '../autor';
import { AutorService } from '../autor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-autor',
  templateUrl: './crear-autor.component.html',
  styleUrls: ['./crear-autor.component.css']
})
export class CrearAutorComponent implements OnInit {

  autor: Autor = new  Autor();
  submitted = false;
  nosubmitted=false;

  constructor(private autorService: AutorService,
    private router: Router 
    ) {

    }

  ngOnInit() {
  }

  newAutor(): void {
    this.submitted = false;
    this.nosubmitted=false;
    this.autor = new Autor();
  }

  save() {
    this.autorService.createAutor(this.autor)
      .subscribe(data => console.log(data), error => console.log(error));
    this.autor = new Autor();
    this.gotoList();
    
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  noSubmit() {
    this.submitted = false;
    this.gotoList2();
 
  }

  gotoList() {
    this.router.navigate(['/ListadoAutores']);
  }
  gotoList2() {
    this.router.navigate(['']);
  }
}
