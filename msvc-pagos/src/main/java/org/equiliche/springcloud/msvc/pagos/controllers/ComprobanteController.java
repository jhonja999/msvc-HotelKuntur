package org.equiliche.springcloud.msvc.pagos.controllers;

import jakarta.validation.Valid;
import org.equiliche.springcloud.msvc.pagos.models.entity.ComprobantePago;
import org.equiliche.springcloud.msvc.pagos.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/comprobante") //
@RestController
public class ComprobanteController {
    @Autowired
    private ComprobanteService service;
    @GetMapping
    public List<ComprobantePago> listar(){
        return service.listar();
    }
    @GetMapping ("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){ //Enviar Valores primitivos
        Optional<ComprobantePago> usuarioOptional = service.porId(id);
        if(usuarioOptional.isPresent()){
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<?> crea(@Valid @RequestBody ComprobantePago comprobantePago, BindingResult result){ //Enviar Objetos
        if(result.hasErrors()){
            Map<String, String> errores=new HashMap<>();
            result.getFieldErrors().forEach(err ->{
                errores.put(err.getField(),"El campo "+ err.getField()+" "+err.getDefaultMessage());
            });
return ResponseEntity.badRequest().body(errores);
        }


        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(comprobantePago));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody ComprobantePago comprobantePago,BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            Map<String, String> errores=new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }
        Optional<ComprobantePago> op = service.porId(id);
        if(op.isPresent()){
            ComprobantePago comprobanteDB = op.get();
            comprobanteDB.setDetalleComprobante(comprobantePago.getDetalleComprobante());
            comprobanteDB.setFechapago(comprobantePago.getFechapago());
            comprobanteDB.setMetodopago(comprobantePago.getMetodopago());
            comprobanteDB.setMonto(comprobantePago.getMonto());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(comprobanteDB));//:)
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<ComprobantePago> op = service.porId(id);
        if(op.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
