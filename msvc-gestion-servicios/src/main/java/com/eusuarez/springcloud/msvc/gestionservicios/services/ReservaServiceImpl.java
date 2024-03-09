package com.eusuarez.springcloud.msvc.gestionservicios.services;

import com.eusuarez.springcloud.msvc.gestionservicios.clients.ClienteClientRest;
import com.eusuarez.springcloud.msvc.gestionservicios.models.entity.Reserva;
import com.eusuarez.springcloud.msvc.gestionservicios.models.aggregate.entity.Cliente;
import com.eusuarez.springcloud.msvc.gestionservicios.repositories.ReservaRepository;

import feign.Feign;
import feign.FeignException;
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

    // M'etodos remotos

    @Autowired
    private ClienteClientRest client;

    @Override
    @Transactional
    public Optional<Cliente> obtenerCliente(Long idCliente) {

        try{
            Cliente clienteMsvc = client.detalle(idCliente);
            return Optional.of(clienteMsvc);
        } catch (FeignException e){
            return Optional.empty();
        }

    }

    @Override
    @Transactional
    public Optional<Cliente> crearCliente(Cliente cliente) {
        Cliente clienteMsvc = client.crear(cliente);

        return Optional.of(clienteMsvc);
    }

}
