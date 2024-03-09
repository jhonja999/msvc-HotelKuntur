package com.eusuarez.springcloud.msvcgestionservicios.services;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.DetallePago;
import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Pago;

import java.util.List;
import java.util.Optional;

public interface DetallePagoService {
    List<DetallePago> listar();
    Optional<DetallePago> porId(Long id);
    DetallePago guardar (DetallePago pago);
    void eliminar(Long id);
}
