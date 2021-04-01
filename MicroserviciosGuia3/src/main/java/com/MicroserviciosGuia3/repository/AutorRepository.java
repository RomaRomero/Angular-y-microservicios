package com.MicroserviciosGuia3.repository;

import java.util.List;
import java.util.Optional;

import com.MicroserviciosGuia3.model.Autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository< Autor, Long>{
    // Optional<User> findByUsername(String username);
    // Optional<Autor> findByUsername(String nombreusuario);
    // List<Autor> findByUsernam(String nombreusuario);
    // Optional<Autor> findBytwitter(String twitter);
    // Optional<Autor> findByfacebook(String facebook);
    // Optional<Autor> findByinstagram(String instagram);

}
