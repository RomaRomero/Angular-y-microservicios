package com.MicroserviciosGuia3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Autor")
public class Autor {


    private long id;
    private String autor;
    private String usuario;
    private String twitter;
    private String facebook;
    private String instagram;
    private String descripcion;
    
    
    public Autor(){
    }
    public Autor(String autor, String usuario, String twitter, String facebook, String instagram, String descripcion){
        this.autor=autor;
        this.usuario=usuario;
        this.twitter=twitter;
        this.facebook=facebook;
        this.instagram=instagram;
        this.descripcion=descripcion;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    @Column(name ="autor", nullable = false)
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor=autor;
    }
    @Column(name ="usuario", nullable = false)
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    @Column(name ="twitter", nullable = false)
    public String getTwitter(){
        return twitter;
    }
    public void setTwitter(String twitter){
        this.twitter=twitter;
    }
    @Column(name ="facebook", nullable = false)
    public String getFacebook(){
        return facebook;
    }
    public void setFacebook(String facebook){
        this.facebook=facebook;
    }
    @Column(name ="instagram", nullable = false)
    public String getInstagram(){
        return instagram;
    }
    public void setInstagram(String instagram){
        this.instagram=instagram;
    }
    @Column(name ="descripcion", nullable = false)
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    @Override
    public String toString(){
        return "Autor [id="+ id +", autor="+ autor +", usuario="+ usuario +", twitter="+ twitter +", facebook="+ facebook + ", instagram="+ instagram +", descripcion="+ descripcion +"]";
    }
}
