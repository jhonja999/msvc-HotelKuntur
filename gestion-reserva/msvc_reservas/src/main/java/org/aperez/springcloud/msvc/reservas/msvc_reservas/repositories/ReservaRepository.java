package org.aperez.springcloud.msvc.reservas.msvc_reservas.repositories;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Reserva;

import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {
}
