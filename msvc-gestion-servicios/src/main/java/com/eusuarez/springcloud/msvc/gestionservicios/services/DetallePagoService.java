package com.eusuarez.springcloud.msvc.gestionservicios.services;

import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.DetallePago;

import java.util.List;
import java.util.Optional;

public interface DetallePagoService {
    List<DetallePago> listar();
    Optional<DetallePago> porId(Long id);
    DetallePago guardar (DetallePago pago);
    void eliminar(Long id);
}
