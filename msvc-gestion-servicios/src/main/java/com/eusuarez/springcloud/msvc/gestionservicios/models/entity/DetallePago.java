package com.eusuarez.springcloud.msvc.gestionservicios.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="detalle_pagos")
public class DetallePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pago")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_pago")
    private Pago pago;
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    public DetallePago(){}

    public DetallePago(long id, Pago pago, Reserva reserva) {
        this.id = id;
        this.pago = pago;
        this.reserva = reserva;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

}
