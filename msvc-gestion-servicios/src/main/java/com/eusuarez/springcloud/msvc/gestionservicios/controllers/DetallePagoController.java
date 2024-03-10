package com.eusuarez.springcloud.msvc.gestionservicios.controllers;

import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.DetallePago;
import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Pago;
import com.eusuarez.springcloud.msvc.gestionservicios.services.DetallePagoService;
import com.eusuarez.springcloud.msvc.gestionservicios.services.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle_pago")
public class DetallePagoController {
    @Autowired
    private DetallePagoService service;

    @GetMapping
    public ResponseEntity<List<DetallePago>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<DetallePago> op = service.porId(id);
        if(op.isPresent()){
            return ResponseEntity.ok(op.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Autowired
    PagoService pagoService;
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody DetallePago detallePago, BindingResult result){
        if(result.hasErrors()) return Validator.validar(result);

        service.guardar(detallePago);

        // Actualizar la tabla pago
        Optional<Pago> opPago = pagoService.porId(detallePago.getPago().getId());
        Pago pagoDb = opPago.orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        pagoDb.calculateTotal(detallePago.getReserva().getServicio());

        pagoService.guardar(pagoDb);

        return ResponseEntity.status(HttpStatus.CREATED).body(detallePago);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody DetallePago detallePago, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()) return Validator.validar(result);

        Optional<DetallePago> op = service.porId(id);
        if(op.isPresent()){
            DetallePago detallePagoDb = op.get();

            detallePagoDb.setReserva(detallePago.getReserva());
            detallePagoDb.setPago(detallePago.getPago());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(detallePagoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        Optional<DetallePago> op = service.porId(id);
        if(op.isPresent()){
            service.eliminar(op.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

}
