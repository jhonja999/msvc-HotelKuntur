package com.eusuarez.springcloud.msvcgestionservicios.services;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<Reserva> listar();
    Optional<Reserva> porId(Long id);
    Reserva guardar (Reserva reserva);
    void eliminar(Long id);
}
