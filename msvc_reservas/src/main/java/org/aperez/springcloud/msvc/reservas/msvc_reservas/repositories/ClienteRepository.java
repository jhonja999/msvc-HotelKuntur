package org.aperez.springcloud.msvc.reservas.msvc_reservas.repositories;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository  extends CrudRepository<Cliente, Long> {
}
