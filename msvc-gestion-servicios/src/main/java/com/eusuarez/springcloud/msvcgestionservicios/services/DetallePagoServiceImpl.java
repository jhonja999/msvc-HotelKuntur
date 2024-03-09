package com.eusuarez.springcloud.msvcgestionservicios.services;

import com.eusuarez.springcloud.msvcgestionservicios.models.entity.DetallePago;
import com.eusuarez.springcloud.msvcgestionservicios.repositories.DetallePagoRepository;
import com.eusuarez.springcloud.msvcgestionservicios.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePagoServiceImpl implements DetallePagoService {

    @Autowired
    private DetallePagoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<DetallePago> listar() {
        return (List<DetallePago>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DetallePago> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public DetallePago guardar(DetallePago detallePago) {
        return repository.save(detallePago);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
