package org.aperez.springcloud.msvc.reservas.msvc_reservas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(unique = true)
    private Long dniCliente;
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String email;
    private String password;
    private String interaccion;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    public Long getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(Long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInteraccion() {
        return interaccion;
    }

    public void setInteraccion(String interaccion) {
        this.interaccion = interaccion;
    }
}
