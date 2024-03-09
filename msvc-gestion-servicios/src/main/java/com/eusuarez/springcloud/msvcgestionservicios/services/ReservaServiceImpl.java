package com.eusuarez.springcloud.msvcgestionservicios.services;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.Reserva;
import com.eusuarez.springcloud.msvcgestionservicios.repositories.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> listar() {
        return (List<Reserva>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reserva> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return repository.save(reserva);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
