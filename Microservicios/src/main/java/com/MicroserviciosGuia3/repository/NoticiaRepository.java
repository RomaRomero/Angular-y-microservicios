package com.MicroserviciosGuia3.repository;

import com.MicroserviciosGuia3.model.Noticia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia , Long>{
    
}
