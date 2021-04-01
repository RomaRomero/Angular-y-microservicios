import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Noticia } from '../noticia';
import { NoticiaService } from '../noticia.service';

@Component({
  selector: 'app-actualizar-publicacion',
  templateUrl: './actualizar-publicacion.component.html',
  styleUrls: ['./actualizar-publicacion.component.css']
})
export class ActualizarPublicacionComponent implements OnInit {

  submitted = false;
  id: number;
  noticia: Noticia;

  constructor(private route: ActivatedRoute,private router: Router,
    private noticiaService: NoticiaService) { }

  ngOnInit() {
    this.noticia = new Noticia();

    this.id = this.route.snapshot.params['id'];
    
    this.noticiaService.getNoticia(this.id)
      .subscribe(data => {
        console.log(data)
        this.noticia = data;
      }, error => console.log(error));
  }

  updatenoticia() {
    this.submitted = false;
    this.noticiaService.updateNoticia(this.id, this.noticia)
      .subscribe(data => console.log(data), error => console.log(error));
    this.noticia = new Noticia();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.updatenoticia();
  }

  gotoList() {
    this.router.navigate(['']);
  }
}
