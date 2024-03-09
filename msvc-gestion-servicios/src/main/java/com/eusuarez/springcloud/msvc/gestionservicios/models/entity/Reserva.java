package com.eusuarez.springcloud.msvc.gestionservicios.models.entity;

import com.eusuarez.springcloud.msvc.gestionservicios.models.valueobject.ServicioTime;
import com.eusuarez.springcloud.msvc.gestionservicios.models.aggregate.entity.Cliente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;
    @Embedded
    @Valid
    private ServicioTime horarioReserva;
    @Column(name = "estado_reserva")
    @NotBlank(message = "Por favor ingrese el estado de la reserva")
    @Pattern(regexp = "^[^0-9]*$", message = "El estado de reserva no debe contener números")
    private String estadoReserva;
    @Embedded
    private Cliente cliente;

    public Reserva(){}
    public Reserva(Long id, Servicio servicio, Cliente cliente, ServicioTime horarioReserva, String estadoReserva) {
        this.id = id;
        this.servicio = servicio;
        this.cliente = cliente;
        this.horarioReserva = horarioReserva;
        this.estadoReserva = estadoReserva;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ServicioTime getHorarioReserva() {
        return horarioReserva;
    }

    public void setHorarioReserva(ServicioTime horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
