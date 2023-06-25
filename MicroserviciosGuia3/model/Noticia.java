package com.MicroserviciosGuia3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Noticia")
public class Noticia {
    private long id;
    private String titulo;
    private String cuerpo;
    private String fechapbl;

    public Noticia(){

    }
    public Noticia(String titulo, String cuerpo, String fechapbl){
        this.titulo=titulo;
        this.cuerpo=cuerpo;
        this.fechapbl=fechapbl;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    @Column(name ="titulo", nullable = false)
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    @Column(name ="cuerpo", nullable = false)
    public String getCuerpo(){
        return cuerpo;
    }
    public void setCuerpo(String cuerpo){
        this.cuerpo=cuerpo;
    }
    @Column(name ="fechap", nullable = false)
    public String getFechapbl(){
        return fechapbl;
    }
    public void setFechapbl(String fechapbl){
        this.fechapbl=fechapbl;
    }
    @Override
    public String toString(){
        return "Noticias [id="+ id +", titulo="+ titulo +", cuerpo="+ cuerpo +", fechap="+ fechapbl +"]";
    }
    

}