import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Autor } from '../autor';
import { AutorService } from '../autor.service';

@Component({
  selector: 'app-listar-autor',
  templateUrl: './listar-autor.component.html',
  styleUrls: ['./listar-autor.component.css']
})
export class ListarAutorComponent implements OnInit {

  autor: Observable<Autor[]>;
  constructor(private autorService: AutorService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.autor = this.autorService.getAutorList();
  }

  deleteAutor(id: number) {
    this.autorService.deleteAutor(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  autorDetails(id: number){
    this.router.navigate(['/Menu/DetallesAutor/',{id}]);
  }
  autorUpdate(id: number){
    this.router.navigate(['/Menu/ActualizarAutor/',{id}]);
  }
}