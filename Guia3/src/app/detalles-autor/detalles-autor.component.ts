import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Autor } from '../autor';
import { AutorService } from '../autor.service';

@Component({
  selector: 'app-detalles-autor',
  templateUrl: './detalles-autor.component.html',
  styleUrls: ['./detalles-autor.component.css']
})
export class DetallesAutorComponent implements OnInit {

  id: number;
  autor: Autor;

  constructor(private route: ActivatedRoute,private router: Router,
    private autorService: AutorService) { }

  ngOnInit() {
    this.autor = new Autor();

    this.id = this.route.snapshot.params['id'];
    
    this.autorService.getAutor(this.id)
      .subscribe(data => {
        console.log(data)
        this.autor = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['/ListadoAutores']);
  }
}