package com.eusuarez.springcloud.msvcgestionservicios.models.entity;

import com.eusuarez.springcloud.msvcgestionservicios.models.valueobject.ServicioTime;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    @Valid
    private Servicio servicio;
    @Column(name = "id_cliente")
    @NotNull(message = "Por favor ingrese el ID del cliente")
    @Positive(message = "El ID del Cliente debe ser mayor a cero")
    private Long idCliente;
    @Embedded
    @Valid
    private ServicioTime horarioReserva;
    @Column(name = "estado_reserva")
    @NotBlank(message = "Por favor ingrese el estado de la reserva")
    @Pattern(regexp = "^[^0-9]*$", message = "El estado de reserva no debe contener números")
    private String estadoReserva;

    public Reserva(){}
    public Reserva(Long id, Servicio servicio, Long idCliente, ServicioTime horarioReserva, String estadoReserva) {
        this.id = id;
        this.servicio = servicio;
        this.idCliente = idCliente;
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

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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
