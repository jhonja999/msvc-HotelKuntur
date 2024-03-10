package com.eusuarez.springcloud.msvc.gestionservicios.controllers;

import com.eusuarez.springcloud.msvc.gestionservicios.models.aggregate.entity.Cliente;
import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Reserva;
import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Servicio;
import com.eusuarez.springcloud.msvc.gestionservicios.services.ReservaService;
import com.eusuarez.springcloud.msvc.gestionservicios.services.ServicioService;
import feign.FeignException;
import feign.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

        // Conexion con cliente
        Optional<Cliente> o;
        try{
            // Obtener cliente
            o = service.obtenerCliente(reserva.getCliente().getId());
        } catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Collections.singletonMap("mensaje", "No se encontr'o el Cliente o error en la comunicacion:" +
                            e.getMessage())
            );
        }

        if(!o.isPresent()){
            try{
                // Crear cliente
                o = service.crearCliente(reserva.getCliente());
            } catch (FeignException e1){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        Collections.singletonMap("mensaje", "No se pudo crear el Cliente o error en la comunicacion:" +
                                e1.getMessage())
                );
            }
        }

        // Guardar cliente en reserva
        reserva.setCliente(o.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Reserva reserva, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()) return Validator.validar(result);

        Optional<Reserva> op = service.porId(id);
        if(op.isPresent()){
            Reserva reservaDb = op.get();

            reservaDb.setHorarioReserva(reserva.getHorarioReserva());
            reservaDb.setEstadoReserva(reserva.getEstadoReserva());

            // Conexion con cliente
            Optional<Cliente> o;
            try{
                // Obtener cliente
                o = service.obtenerCliente(reserva.getCliente().getId());
            } catch (FeignException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        Collections.singletonMap("mensaje", "No se encontr'o el Cliente o error en la comunicacion:" +
                                e.getMessage())
                );
            }

            if(!o.isPresent()){
                try{
                    // Crear cliente
                    o = service.crearCliente(reserva.getCliente());
                } catch (FeignException e1){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                            Collections.singletonMap("mensaje", "No se pudo crear el Cliente o error en la comunicacion:" +
                                    e1.getMessage())
                    );
                }
            }

            // Guardar cliente en reserva
            reservaDb.setCliente(o.get());

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

    // M'etodos remotos

    @GetMapping("/obtener-cliente/{id_cliente}")
    public ResponseEntity<?> obtenerCliente(@PathVariable Long id_cliente){
        Optional<Cliente> o;
        try{
            o = service.obtenerCliente(id_cliente);
        } catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Collections.singletonMap("mensaje", "No existe el cliente por el id o error en la comunicacion:" +
                            e.getMessage())
            );
        }
        if(o.isPresent()){
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crear-cliente")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
        Optional<Cliente> o;
        try{
            o = service.crearCliente(cliente);
        } catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Collections.singletonMap("mensaje", "No se pudo crear el Cliente o error en la comunicacion:" +
                            e.getMessage())
            );
        }
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.get());
        }

        return ResponseEntity.notFound().build();
    }

}
