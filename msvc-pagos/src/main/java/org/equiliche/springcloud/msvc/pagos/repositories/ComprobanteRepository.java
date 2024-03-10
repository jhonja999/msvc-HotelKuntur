package org.equiliche.springcloud.msvc.pagos.repositories;

import org.equiliche.springcloud.msvc.pagos.models.entity.ComprobantePago;
import org.springframework.data.repository.CrudRepository;

public interface ComprobanteRepository extends CrudRepository<ComprobantePago, Long> {
}
