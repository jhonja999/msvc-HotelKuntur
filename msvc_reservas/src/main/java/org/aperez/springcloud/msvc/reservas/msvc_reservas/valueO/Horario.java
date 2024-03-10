package org.aperez.springcloud.msvc.reservas.msvc_reservas.valueO;

import java.time.LocalTime;

public class Horario {
    private LocalTime horaIngreso;
    private LocalTime horaSalida;

    public Horario(LocalTime horaIngreso, LocalTime horaSalida) {
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
