package com.eusuarez.springcloud.msvcgestionservicios.models.valueobject;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ServicioTime {

    @Column(name = "fecha")
    @NotNull(message = "Por favor ingrese la fecha")
    @FutureOrPresent(message = "La fecha debe ser la fecha actual o posterior")
    private LocalDate fecha;
    @Column(name = "hora")
    @NotNull(message = "Por favor ingrese la hora")
    private LocalTime hora;
    @Column(name = "duracion_min")
    @NotNull(message = "Por favor ingrese la duracion en minutos")
    @Positive(message = "La duración debe ser mayor a cero")
    private int duracionMinutos;

    public ServicioTime(){}
    public ServicioTime(LocalDate fecha, LocalTime hora, int duracionMinutos) {
        this.fecha = fecha;
        this.hora = hora;
        this.duracionMinutos = duracionMinutos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getDuracionMinutos() { return duracionMinutos; }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicioTime that = (ServicioTime) o;

        return duracionMinutos == that.duracionMinutos &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(hora, that.hora);
    }

    @Override
    public String toString() {
        return "ServicioTime{" +
                "fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                '}';
    }

}
