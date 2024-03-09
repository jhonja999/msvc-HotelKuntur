package com.eusuarez.springcloud.msvcgestionservicios.services;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Servicio;
import com.eusuarez.springcloud.msvcgestionservicios.repositories.ServicioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> listar() {
        return (List<Servicio>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Servicio> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Servicio guardar(Servicio servicio) {
        return repository.save(servicio);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
