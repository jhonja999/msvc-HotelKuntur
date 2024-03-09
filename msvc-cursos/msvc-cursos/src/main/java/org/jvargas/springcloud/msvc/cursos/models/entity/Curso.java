package org.jvargas.springcloud.msvc.cursos.models.entity;

import jakarta.persistence.*;
import org.jvargas.springcloud.msvc.cursos.models.Cliente;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CursoCliente> cursoClientes;//relacion de ids

    @Transient
    private List<Cliente> clientes;

    public Curso(){
        cursoClientes = new ArrayList<>();}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CursoCliente> getCursoCliente() {
        return cursoClientes;
    }

    public void setCursoCliente(List<CursoCliente> cursoClientes) {
        this.cursoClientes = cursoClientes;
    }

    public void addCursoCliente(CursoCliente cursoCliente) {

        cursoClientes.add(cursoCliente);//verificar this
    }

    public void removeCursoCliente(CursoCliente cursoCliente) {
        cursoClientes.remove(cursoCliente);
    }
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
