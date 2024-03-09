package com.eusuarez.springcloud.msvcgestionservicios.controllers;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Pago;
import com.eusuarez.springcloud.msvcgestionservicios.services.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
    @Autowired
    private PagoService service;

    @GetMapping
    public ResponseEntity<List<Pago>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Pago> op = service.porId(id);
        if(op.isPresent()){
            return ResponseEntity.ok(op.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Pago pago, BindingResult result){
        if(result.hasErrors()) return Validator.validar(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Pago pago, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()) return Validator.validar(result);

        Optional<Pago> op = service.porId(id);
        if(op.isPresent()){
            Pago pagoDb = op.get();

            pagoDb.setIdCliente(pago.getIdCliente());
            pagoDb.setFechaYHora(pago.getFechaYHora());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(pagoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        Optional<Pago> op = service.porId(id);
        if(op.isPresent()){
            service.eliminar(op.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

}
