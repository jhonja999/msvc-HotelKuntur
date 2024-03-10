package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Trabajador;

import java.util.List;
import java.util.Optional;

public interface TrabajadorService {
    List<Trabajador> listar();
    Optional<Trabajador> porId(Long id);
    Trabajador guardar(Trabajador cliente);
    void eliminar(Long id);
}
