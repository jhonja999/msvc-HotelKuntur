package org.equiliche.springcloud.msvc.pagos.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="comprobante")
public class   ComprobantePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodoPago;
    @Pattern(regexp = "[^0-9]*", message = "no debe contener números")
    @NotEmpty
    private String metodopago;
    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0", inclusive = false, message = "El monto debe ser mayor que cero")
    private double monto;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date fechapago;
    @NotEmpty
    private String detalleComprobante;

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getDetalleComprobante() {
        return detalleComprobante;
    }

    public void setDetalleComprobante(String detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
    }
}

