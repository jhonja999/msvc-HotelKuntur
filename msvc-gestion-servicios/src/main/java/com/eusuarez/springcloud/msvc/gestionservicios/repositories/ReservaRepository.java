package com.eusuarez.springcloud.msvc.gestionservicios.repositories;

import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {
}
