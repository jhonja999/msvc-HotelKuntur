package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Habitacion;

import java.util.List;
import java.util.Optional;

public interface HabitacionService {
    List<Habitacion> listar();
    Optional<Habitacion> porId(Long id);
    Habitacion guardar(Habitacion cliente);
    void eliminar(Long id);
}
