package org.aperez.springcloud.msvc.reservas.msvc_reservas.entity;
import jakarta.persistence.*;
import org.aperez.springcloud.msvc.reservas.msvc_reservas.valueO.Estadia;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dni_cliente") // Nombre de la columna en la tabla Reserva que hace referencia al cliente
    private Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habitacion") // Nombre de la columna en la tabla Reserva que hace referencia a la habitación
    private Habitacion habitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trabajador") // Nombre de la columna en la tabla Reserva que hace referencia al trabajador
    private Trabajador trabajador;

    @Embedded
    private Estadia estadia;

}
