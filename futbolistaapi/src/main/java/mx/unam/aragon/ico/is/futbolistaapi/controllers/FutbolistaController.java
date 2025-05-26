package mx.unam.aragon.ico.is.futbolistaapi.controllers;


import mx.unam.aragon.ico.is.futbolistaapi.entities.Futbolista;
import mx.unam.aragon.ico.is.futbolistaapi.services.interfaces.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/futbolistas")
public class FutbolistaController {


    @Autowired
    private FutbolistaService futbolistaService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Futbolista>> getFutbolistas(){

        return ResponseEntity.ok().body(futbolistaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Futbolista> getFutbolista(@PathVariable Long id){
        return ResponseEntity.ok(futbolistaService.buscarPorId(id).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<Futbolista> createFutbolista(@RequestBody Futbolista futbolista) throws URISyntaxException {

        return ResponseEntity.created(new URI("http://localhost:8090/")).body(futbolistaService.crear(futbolista));
    }




}
