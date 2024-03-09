package com.eusuarez.springcloud.msvc.gestionservicios.services;

import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Servicio;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    List<Servicio> listar();
    Optional<Servicio> porId(Long id);
    Servicio guardar (Servicio servicio);
    void eliminar(Long id);
}
