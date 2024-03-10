package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    Cliente guardar(Cliente cliente);
    void eliminar(Long id);
}
