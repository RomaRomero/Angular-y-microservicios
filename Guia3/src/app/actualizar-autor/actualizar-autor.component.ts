import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Autor } from '../autor';
import { AutorService } from '../autor.service';

@Component({
  selector: 'app-actualizar-autor',
  templateUrl: './actualizar-autor.component.html',
  styleUrls: ['./actualizar-autor.component.css']
})
export class ActualizarAutorComponent implements OnInit {

  submitted = false;
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

  updateAutor() {
    this.submitted = false;
    this.autorService.updateAutor(this.id, this.autor)
      .subscribe(data => console.log(data), error => console.log(error));
    this.autor = new Autor();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.updateAutor();
  }

  gotoList() {
    this.router.navigate(['/ListadoAutores']);
  }
}
