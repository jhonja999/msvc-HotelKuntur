package com.eusuarez.springcloud.msvcgestionservicios.repositories;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {
}
