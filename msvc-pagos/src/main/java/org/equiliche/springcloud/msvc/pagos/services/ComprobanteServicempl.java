package org.equiliche.springcloud.msvc.pagos.services;


import org.equiliche.springcloud.msvc.pagos.models.entity.ComprobantePago;
import org.equiliche.springcloud.msvc.pagos.repositories.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComprobanteServicempl implements  ComprobanteService{
    @Autowired //para inyectar la dependencia de una clase con metodos
    private ComprobanteRepository repository;

    @Override
    @Transactional(readOnly  = true) //springframework.transaction.annotation - solo de lectura
    public List<ComprobantePago> listar() {
        return (List<ComprobantePago>) repository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<ComprobantePago> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public ComprobantePago guardar(ComprobantePago comprobantePago) {
        return repository.save(comprobantePago);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}