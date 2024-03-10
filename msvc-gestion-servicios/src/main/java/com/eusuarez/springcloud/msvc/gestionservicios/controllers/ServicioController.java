package com.eusuarez.springcloud.msvc.gestionservicios.controllers;

import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Servicio;
import com.eusuarez.springcloud.msvc.gestionservicios.services.ServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {
    @Autowired
    private ServicioService service;

    @GetMapping
    public ResponseEntity<List<Servicio>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Servicio> op = service.porId(id);
        if(op.isPresent()){
            return ResponseEntity.ok(op.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Servicio servicio, BindingResult result){
        if(result.hasErrors()) return Validator.validar(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Servicio servicio, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()) return Validator.validar(result);

        Optional<Servicio> op = service.porId(id);
        if(op.isPresent()){
            Servicio servicioDb = op.get();

            servicioDb.setTipo(servicio.getTipo());
            servicioDb.setDisponibilidad(servicio.isDisponibilidad());
            servicioDb.setPrecio(servicio.getPrecio());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(servicioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        Optional<Servicio> op = service.porId(id);
        if(op.isPresent()){
            service.eliminar(op.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
