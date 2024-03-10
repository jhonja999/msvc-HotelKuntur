package com.eusuarez.springcloud.msvc.gestionservicios.models.valueobject;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class TipoServicio {
    @Column(name = "nombre")
    @NotBlank(message = "Por favor ingrese el nombre del servicio")
    @Pattern(regexp = "^[^0-9]*$", message = "El nombre no debe contener números")
    private String nombre;
    @Column(name = "descripcion")
    @NotBlank(message = "Por favor ingrese la descripción del servicio")
    @Pattern(regexp = "^[^0-9]*$", message = "La descripción no debe contener números")
    private String descripcion;

    public TipoServicio(){}

    public TipoServicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoServicio that = (TipoServicio) o;

        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public String toString() {
        return "TipoServicio{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
