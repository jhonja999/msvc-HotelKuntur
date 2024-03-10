package org.aperez.springcloud.msvc.reservas.msvc_reservas.services;

import org.aperez.springcloud.msvc.reservas.msvc_reservas.entity.Cliente;
import org.aperez.springcloud.msvc.reservas.msvc_reservas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository repository;
    @Override
    @Transactional(readOnly=true)
    public List<Cliente> listar() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Cliente> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Cliente guardar(Cliente cliente) {
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

    }
}
