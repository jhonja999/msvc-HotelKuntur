package com.eusuarez.springcloud.msvcgestionservicios.services;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Servicio;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    List<Servicio> listar();
    Optional<Servicio> porId(Long id);
    Servicio guardar (Servicio servicio);
    void eliminar(Long id);
}
