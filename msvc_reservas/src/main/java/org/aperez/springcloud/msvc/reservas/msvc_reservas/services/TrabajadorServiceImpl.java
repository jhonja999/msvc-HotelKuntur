package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Trabajador;
import org.aperez.springcloud.msvc.reservas.msvc_reservas.repositories.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorServiceImpl implements TrabajadorService{
    @Autowired
    TrabajadorRepository repository;
    @Override
    @Transactional(readOnly=true)
    public List<Trabajador> listar() {
        return (List<Trabajador>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Trabajador> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Trabajador guardar(Trabajador cliente) {
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

    }
}
