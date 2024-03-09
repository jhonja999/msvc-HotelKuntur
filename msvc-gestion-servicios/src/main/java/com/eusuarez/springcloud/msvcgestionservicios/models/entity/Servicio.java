package com.eusuarez.springcloud.msvcgestionservicios.models.entity;

import com.eusuarez.springcloud.msvcgestionservicios.models.valueobject.TipoServicio;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private long id;

    @Embedded
    @Valid
    private TipoServicio tipo;
    @Column(name = "disponibilidad")
    @NotNull(message = "Por favor ingrese la disponibilidad del servicio")
    private boolean disponibilidad;
    @Column(name = "precio")
    @NotNull(message = "Por favor ingrese el precio del servicio")
    @Positive(message = "El precio debe ser mayor a cero")
    private float precio;

    public Servicio(){}
    public Servicio(long id, TipoServicio tipo, boolean disponibilidad, float precio) {
        this.id = id;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
