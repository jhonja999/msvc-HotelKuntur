package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Reserva;
import org.aperez.springcloud.msvc.reservas.msvc_reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ReservaServiceImpl implements ReservaService{

    @Autowired
    private ReservaRepository repository;
    @Override
    @Transactional(readOnly=true)
    public List<Reserva> listar() {
        return (List<Reserva>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Reserva> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Reserva guardar(Reserva cliente) {
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

    }
}
