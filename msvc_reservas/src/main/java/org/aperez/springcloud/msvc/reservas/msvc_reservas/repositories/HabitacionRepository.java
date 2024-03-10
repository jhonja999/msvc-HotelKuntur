package org.aperez.springcloud.msvc.reservas.msvc_reservas.repositories;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Habitacion;
import org.springframework.data.repository.CrudRepository;

public interface HabitacionRepository  extends CrudRepository<Habitacion, Long> {
}
