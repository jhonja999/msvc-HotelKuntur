package org.jvargas.springcloud.msvc.cursos.services;

import org.jvargas.springcloud.msvc.cursos.clients.ClientesClientRest;
import org.jvargas.springcloud.msvc.cursos.models.Cliente;
import org.jvargas.springcloud.msvc.cursos.models.entity.Curso;
import org.jvargas.springcloud.msvc.cursos.models.entity.CursoCliente;
import org.jvargas.springcloud.msvc.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicempl implements CursoService {

    @Autowired
    private CursoRepository repository;
    @Autowired
    private ClientesClientRest client;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return (List<Curso>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Cliente> asignarCliente(Cliente cliente, Long cursoId) {
        Optional<Curso> o= repository.findById(cursoId);
        if (o.isPresent()){
            Cliente clienteMsvc= client.detalle(cliente.getId());//solo id
            Curso curso = o.get();
            CursoCliente cursoCliente = new CursoCliente();
            cursoCliente.setClienteId(clienteMsvc.getId());

            curso.addCursoCliente(cursoCliente);
            repository.save(curso);
            return Optional.of(clienteMsvc);
        }


        return Optional.empty();
    }

    @Override
    public Optional<Cliente> crearCliente(Cliente cliente, Long cursoId) {
        Optional<Curso> o= repository.findById(cursoId);
        if (o.isPresent()){
            Cliente clienteNewMsvc= client.crear(cliente); //todo el usuario, cliente New MSVC-para nuevos
            Curso curso = o.get();
            CursoCliente cursoCliente = new CursoCliente();
            cursoCliente.setClienteId(clienteNewMsvc.getId());

            curso.addCursoCliente(cursoCliente);
            repository.save(curso);
            return Optional.of(clienteNewMsvc);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Cliente> eliminarCliente(Cliente cliente, Long cursoId) {
        Optional<Curso> o= repository.findById(cursoId);
        if (o.isPresent()){
            Cliente clienteMsvc= client.detalle(cliente.getId());//solo id
            Curso curso = o.get();
            CursoCliente cursoCliente = new CursoCliente();
            cursoCliente.setClienteId(clienteMsvc.getId());

            curso.removeCursoCliente(cursoCliente);//cambiar por metodo eliminar
            repository.save(curso);
            return Optional.of(clienteMsvc);
        }
        return Optional.empty();
    }
}
