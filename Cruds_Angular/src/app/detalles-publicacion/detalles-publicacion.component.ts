import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Noticia } from '../noticia';
import { NoticiaService } from '../noticia.service';

@Component({
  selector: 'app-detalles-publicacion',
  templateUrl: './detalles-publicacion.component.html',
  styleUrls: ['./detalles-publicacion.component.css']
})
export class DetallesPublicacionComponent implements OnInit {

 
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

  list(){
    this.router.navigate(['']);
  }
}
