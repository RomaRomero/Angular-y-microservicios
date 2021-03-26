package com.MicroserviciosGuia3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.MicroserviciosGuia3.exception.ResourceNotFoundException;
import com.MicroserviciosGuia3.model.Autor;
import com.MicroserviciosGuia3.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/Autor")
    public List<Autor> getAllAutors() {
        return autorRepository.findAll();
    }

    // @GetMapping("/listar")
    // public RespuestaGenerica<Employee> getAllEmployees() {
    // int codigo = 0;
    // String mensaje = "datos obtenidos correctamente";
    // List<Employee> datos = employeeRepository.findAll();
    // RespuestaGenerica<Employee> respuesta = new
    // RespuestaGenerica<Employee>(codigo, mensaje, datos);
    // return respuesta;
    // }

    @GetMapping("/Autor/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable(value = "id") Long autorId)
            throws ResourceNotFoundException {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encotrado para esta id :: " + autorId));
        return ResponseEntity.ok().body(autor);
    }

    // @GetMapping("/listar/{nombreusuario}")
    // public ResponseEntity<List<Autor>> findByNombreUsuario(@PathVariable(value = "nombreusuario")String nombreusuario) {
    //   try {
    //     List<Autor> autor = autorRepository.findByUsernam(nombreusuario);
  
    //     if (autor.isEmpty()) {
    //       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    //     return new ResponseEntity<>(autor, HttpStatus.OK);
    //   } catch (Exception e) {
    //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //   }
    // }
    
    
    // @GetMapping("/listar/{nombreusuario}")
    // public ResponseEntity<Autor> getAutorByusuario(@PathVariable(value = "nombreusuario") String nombreusuario)
    //         {
    //     Autor autor =  autorRepository.findByUsernam(nombreusuario)
    //             .orElseThrow(() -> new ResourceNotFoundException("Autor no encotrado para esta id :: " + nombreusuario));
    //     return ResponseEntity.ok().body(autor);
    // }
    
    // @GetMapping("/listar/{nombreusuario}")
    // public ResponseEntity<Autor> getAutorByNombreUsuario(@PathVariable(value = "nombreusuario") String nombreusuario){
    //     Autor autor = autorRepository.findByUsername(nombreusuario)
    //             .orElseThrow(()->new  ResourceNotFoundException(" No se ha encontrado este usuario=" + nombreusuario));
    //     return ResponseEntity.ok().body(autor);
    // }
    //  @GetMapping("/listar/{twitter}")
    // public ResponseEntity<Autor> getAutorByTwitter(@PathVariable(value = "twitter") String twitter){
    //     Autor autor = autorRepository.findBytwitter(twitter)
    //             .orElseThrow(()->new  ResourceNotFoundException(" Este Twitter no se ha encontrado ="+ twitter));
    //     return ResponseEntity.ok().body(autor);
    // }
    // @GetMapping("/listar/{facebook}")
    // public ResponseEntity<Autor> getAutorByFacebook(@PathVariable(value = "facebook") String facebook){
    //     Autor autor = autorRepository.findByfacebook(facebook)
    //             .orElseThrow(()->new  ResourceNotFoundException("Este facebook no se ha encontrado ="+ facebook));
    //     return ResponseEntity.ok().body(autor);
    // }
    // @GetMapping("/listar/{twitter}")
    // public ResponseEntity<Autor> getAutorByInstagram(@PathVariable(value = "instagram") String instagram){
    //     Autor autor = autorRepository.findByinstagram(instagram)
    //             .orElseThrow(()->new  ResourceNotFoundException("No se han encontrado Intagram Con = "+ instagram ));
    //     return ResponseEntity.ok().body(autor);
    // }
 
    @PostMapping("/Autor")
    public Autor createAutor(@Valid @RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/Autor/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable(value = "id") Long autorId,
            @Valid @RequestBody Autor autorDetails) throws ResourceNotFoundException {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encotrado para este id :: " + autorId));

        autor.setAutor(autorDetails.getAutor());
        autor.setUsuario(autorDetails.getUsuario());
        autor.setTwitter(autorDetails.getTwitter());
        autor.setFacebook(autorDetails.getFacebook());
        autor.setInstagram(autorDetails.getInstagram());
        autor.setDescripcion(autorDetails.getDescripcion());
        
        final Autor updatedAutor = autorRepository.save(autor);
        return ResponseEntity.ok(updatedAutor);
    }

    @DeleteMapping("/Autor/{id}")
    public Map<String, Boolean> deleteAutor(@PathVariable(value = "id") Long AutorId)
            throws ResourceNotFoundException {
        Autor autor = autorRepository.findById(AutorId)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encotrado para este id :: " + AutorId));

        autorRepository.delete(autor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
    }

}
