package mx.unam.aragon.ico.is.futbolistaapi.controllers;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import mx.unam.aragon.ico.is.futbolistaapi.entities.Futbolista;
import mx.unam.aragon.ico.is.futbolistaapi.services.interfaces.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/futbolistas")
public class FutbolistaController {


    @Autowired
    private FutbolistaService futbolistaService;

    //REGRESA TODAS
    @GetMapping("/")
    public ResponseEntity<Iterable<Futbolista>> getFutbolistas() {

        return ResponseEntity.ok().body(futbolistaService.listarTodos());
    }

    //REGRESA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Futbolista> getFutbolista(@PathVariable Integer id) {
        return ResponseEntity.ok(futbolistaService.buscarPorId(id).orElse(null));
    }

    //CREA
    @PostMapping("/")
    public ResponseEntity<Futbolista> createFutbolista(@Valid @RequestBody Futbolista futbolista) throws URISyntaxException {

        return ResponseEntity.created(new URI("http://localhost:8090/")).body(futbolistaService.crear(futbolista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Futbolista>
        updateFutbolista(@PathVariable Integer id, @RequestBody Futbolista futbolista){

        return ResponseEntity.ok(futbolistaService.actualizar(id, futbolista));
    }

    //PATH
    @PatchMapping("/{id}")
    public ResponseEntity<Futbolista> patchFutbolista(@PathVariable Integer id,
                                                      @RequestBody Futbolista futbolista){

        Optional<Futbolista>  tmp= futbolistaService.buscarPorId(id);
        if(tmp.isPresent()){

            Futbolista actual =tmp.get();
            if (futbolista.getNombre() != null) actual.setNombre(futbolista.getNombre());
            if (futbolista.getNacionalidad() != null) actual.setNacionalidad(futbolista.getNacionalidad());
            if (futbolista.getFoto() != null) actual.setFoto(futbolista.getFoto());
            if (futbolista.getAltura() != null) actual.setAltura(futbolista.getAltura());
            return ResponseEntity.ok(futbolistaService.actualizar(id,actual));

        }else {

            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/{id}")
    public void deleteFutbolista(@PathVariable Integer id){

       futbolistaService.eliminar(id);
    }


}
