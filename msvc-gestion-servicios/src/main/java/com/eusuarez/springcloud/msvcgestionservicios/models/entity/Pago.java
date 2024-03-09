package com.eusuarez.springcloud.msvcgestionservicios.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    @Column(name = "id_cliente")
    @NotNull(message = "Por favor ingrese el ID del cliente")
    @Positive(message = "El ID del cliente debe ser mayor a cero")
    private Long idCliente;
    @Column(name = "fecha_y_hora")
    @NotNull(message = "Por favor ingrese la fecha y la hora")
    @FutureOrPresent(message = "La fecha y la hora deben ser actuales o posteriores")
    private LocalDateTime fechaYHora;
    @Column(name = "subtotal")
    private float subtotal;
    @Column(name = "igv")
    private float igv;
    @Column(name = "total")
    private float total;

    public Pago(){}
    public Pago(Long id, Long idCliente, LocalDateTime fechaYHora) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaYHora = fechaYHora;
    }

    public void calculateTotal(Servicio servicio) {
        this.subtotal += servicio.getPrecio();
        this.igv = this.subtotal * 0.18f;
        this.total += subtotal + igv;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public float getSubtotal() { return subtotal; }

    public float getIgv() { return igv; }

    public float getTotal() {
        return total;
    }

}
