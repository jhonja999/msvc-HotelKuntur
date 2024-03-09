package com.eusuarez.springcloud.msvc.gestionservicios.clients;

import com.eusuarez.springcloud.msvc.gestionservicios.models.aggregate.entity.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="msvc-clientes", url="localhost:8002/api/cliente")
public interface ClienteClientRest {
    @GetMapping("/{id}")
    Cliente detalle(@PathVariable Long id);

    @PostMapping
    Cliente crear(@RequestBody Cliente cliente);

}
