import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NoticiaService {
  private baseUrl = 'http://localhost:9898/api/v2/Noticia/';

  constructor(private http: HttpClient) { }
  getNoticia(id: number): Observable<any> {
        return this.http.get(`${this.baseUrl}/${id}`);
    }

    createNoticia(noticia: Object): Observable<Object> {
        return this.http.post(`${this.baseUrl}`, noticia);
    }

    updateNoticia(id: number, value: any): Observable<Object> {
        return this.http.put(`${this.baseUrl}/${id}`, value);
    }

    deleteNoticia(id: number): Observable<any> {
        return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
    }

    getNoticiaList(): Observable<any> {
        return this.http.get(`${this.baseUrl}`);
    }
}
