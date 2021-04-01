import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActualizarAutorComponent } from './actualizar-autor/actualizar-autor.component';
import { ActualizarPublicacionComponent } from './actualizar-publicacion/actualizar-publicacion.component';
import { CrearAutorComponent } from './crear-autor/crear-autor.component';
import { CrearPublicacionComponent } from './crear-publicacion/crear-publicacion.component';
import { DetallesAutorComponent } from './detalles-autor/detalles-autor.component';
import { DetallesPublicacionComponent } from './detalles-publicacion/detalles-publicacion.component';
import { ListarAutorComponent } from './listar-autor/listar-autor.component';
import { ListarPublicacionComponent } from './listar-publicacion/listar-publicacion.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  {path:'' ,redirectTo:'Menu',pathMatch:'full'},
  {path:'Menu', component: MenuComponent },
  {path:'Menu/CrearAutor', component: CrearAutorComponent },
  {path:'Menu/ActualizarAutor', component: ActualizarAutorComponent },
  {path:'Menu/ActualizarAutor/{id}', component: ActualizarAutorComponent },
  {path:'Menu/DetallesAutor', component: DetallesAutorComponent },
  {path:'Menu/DetallesAutor/{id}', component: DetallesAutorComponent },
  {path:'ListadoAutores', component: ListarAutorComponent },

  {path:'Menu/CrearPublicacion', component: CrearPublicacionComponent },
  {path:'Menu/ActualizarPublicacion', component: ActualizarPublicacionComponent },
  {path:'Menu/ActualizarPublicacion/{id}', component: ActualizarPublicacionComponent },
  {path:'Menu/DetallesPublicacion', component: DetallesPublicacionComponent },
  {path:'Menu/DetallesPublicacion/{id}', component: DetallesPublicacionComponent },
  {path:'Menu/ListadoPublicaciones', component: ListarPublicacionComponent },
  {path:'ListadoPublicaciones', component: ListarPublicacionComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
