package com.eusuarez.springcloud.msvcgestionservicios.controllers;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Reserva;
import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Servicio;
import com.eusuarez.springcloud.msvcgestionservicios.services.ReservaService;
import com.eusuarez.springcloud.msvcgestionservicios.services.ServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Reserva> op = service.porId(id);
        if(op.isPresent()){
            return ResponseEntity.ok(op.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Autowired
    ServicioService servicioService;
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Reserva reserva, BindingResult result){
        if(result.hasErrors()) return Validator.validar(result);

        // Verificar que el servicio esté disponible
        Optional<Servicio> opServicio = servicioService.porId(reserva.getServicio().getId());
        Servicio servicio = servicioService.porId(reserva.getServicio().getId()).orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        if(!servicio.isDisponibilidad()) return Validator.badRequest(result, "El servicio no está disponible");

        service.guardar(reserva);

        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Reserva reserva, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()) return Validator.validar(result);

        Optional<Reserva> op = service.porId(id);
        if(op.isPresent()){
            Reserva reservaDb = op.get();

            reservaDb.setIdCliente(reserva.getIdCliente());

            reservaDb.setHorarioReserva(reserva.getHorarioReserva());
            reservaDb.setEstadoReserva(reserva.getEstadoReserva());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(reservaDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        Optional<Reserva> op = service.porId(id);
        if(op.isPresent()){
            service.eliminar(op.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
