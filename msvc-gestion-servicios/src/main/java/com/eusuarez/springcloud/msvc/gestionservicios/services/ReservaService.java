package com.eusuarez.springcloud.msvc.gestionservicios.services;

import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Reserva;
import com.eusuarez.springcloud.msvc.gestionservicios.models.aggregate.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<Reserva> listar();
    Optional<Reserva> porId(Long id);
    Reserva guardar (Reserva reserva);
    void eliminar(Long id);

    // M'etodos remotos
    Optional<Cliente> obtenerCliente(Long idCliente);

    Optional<Cliente> crearCliente(Cliente cliente);
}
