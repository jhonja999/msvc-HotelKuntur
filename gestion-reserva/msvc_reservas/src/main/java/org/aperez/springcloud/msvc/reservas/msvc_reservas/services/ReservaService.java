package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> listar();
    Optional<Reserva> porId(Long id);
    Reserva guardar(Reserva cliente);
    void eliminar(Long id);

}
