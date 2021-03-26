import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Noticia } from '../noticia';
import { NoticiaService } from '../noticia.service';

@Component({
  selector: 'app-crear-publicacion',
  templateUrl: './crear-publicacion.component.html',
  styleUrls: ['./crear-publicacion.component.css']
})
export class CrearPublicacionComponent implements OnInit {

 
  noticia: Noticia = new  Noticia();
  submitted = false;
  nosubmitted=false;

  constructor(private noticiaService: NoticiaService,
    private router: Router 
    ) {

    }

  ngOnInit() {
  }

  newNoticia(): void {
    this.submitted = false;
    this.nosubmitted=false;
    this.noticia = new Noticia();
  }

  save() {
    this.noticiaService.createNoticia(this.noticia)
      .subscribe(data => console.log(data), error => console.log(error));
    this.noticia = new Noticia();
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
    this.router.navigate(['']);
  }
  gotoList2() {
    this.router.navigate(['']);
  }
}
