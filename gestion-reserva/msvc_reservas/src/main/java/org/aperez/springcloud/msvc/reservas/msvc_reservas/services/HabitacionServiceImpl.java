package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Habitacion;
import org.aperez.springcloud.msvc.reservas.msvc_reservas.repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class HabitacionServiceImpl implements HabitacionService{
    @Autowired
    HabitacionRepository repository;
    @Override
    @Transactional(readOnly=true)
    public List<Habitacion> listar() {
        return (List<Habitacion>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Habitacion> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Habitacion guardar(Habitacion cliente) {
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

    }
}
