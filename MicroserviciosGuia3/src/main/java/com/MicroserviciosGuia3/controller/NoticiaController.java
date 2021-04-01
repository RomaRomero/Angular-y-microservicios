package com.MicroserviciosGuia3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.MicroserviciosGuia3.exception.ResourceNotFoundException;
import com.MicroserviciosGuia3.model.Noticia;
import com.MicroserviciosGuia3.repository.NoticiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2")
public class NoticiaController {
    @Autowired
    private NoticiaRepository noticiasRepository;

    @GetMapping("/Noticia")
    public List<Noticia> getAllNoticias() {
        return noticiasRepository.findAll();
    }

    @GetMapping("/Noticia/{id}")
    public ResponseEntity<Noticia> getNoticiaById(@PathVariable(value = "id") Long noticiaId)
            throws ResourceNotFoundException {
        Noticia noticia = noticiasRepository.findById(noticiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Noticia no encotrado para esta id :: " + noticiaId));
        return ResponseEntity.ok().body(noticia);
    }

 
    @PostMapping("/Noticia")
    public Noticia createNoticia(@Valid @RequestBody Noticia noticia) {
        return noticiasRepository.save(noticia);
    }

    @PutMapping("/Noticia/{id}")
    public ResponseEntity<Noticia> updateNoticia(@PathVariable(value = "id") Long noticiaId,
            @Valid @RequestBody Noticia noticiasDetails) throws ResourceNotFoundException {
        Noticia noticias = noticiasRepository.findById(noticiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Noticias no encotrado para este id :: " + noticiaId));

                noticias.setTitulo(noticiasDetails.getTitulo());
                noticias.setCuerpo(noticiasDetails.getCuerpo());
                noticias.setFechapbl(noticiasDetails.getFechapbl());
        final Noticia updatedNoticias = noticiasRepository.save(noticias);
        return ResponseEntity.ok(updatedNoticias);
    }

    @DeleteMapping("/Noticia/{id}")
    public Map<String, Boolean> deleteNoticia(@PathVariable(value = "id") Long noticiaId)
            throws ResourceNotFoundException {
        Noticia noticias = noticiasRepository.findById(noticiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Noticia no encotrado para este id :: " + noticiaId));

        noticiasRepository.delete(noticias);
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
    }

}