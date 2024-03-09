package org.jvargas.springcloud.msvc.cursos.services;

import org.jvargas.springcloud.msvc.cursos.models.Cliente;
import org.jvargas.springcloud.msvc.cursos.models.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> listar();
    Optional<Curso> porId(Long id);
    Curso guardar (Curso curso);
    void eliminar (Long id);

    //Métodos remotos relacionados al cliente http
    //(Al ApiRest que comunicar con el otro msvc)

    Optional<Cliente>asignarCliente(Cliente cliente, Long cursoId);
    Optional<Cliente>crearCliente(Cliente cliente, Long cursoId);
    Optional<Cliente>eliminarCliente(Cliente cliente, Long cursoId);//elimina de la base de datos , no de la relacion
}
