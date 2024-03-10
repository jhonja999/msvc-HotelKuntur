package org.equiliche.springcloud.msvc.pagos.services;

import org.equiliche.springcloud.msvc.pagos.models.entity.ComprobantePago;

import java.util.List;
import java.util.Optional;

public interface ComprobanteService {

    List<ComprobantePago> listar(); //lista  user
    Optional<ComprobantePago> porId(Long id); //te devuelve un solo valor
    Object guardar(ComprobantePago comprobante); //para gaurdar los datos o un user
    void eliminar(Long id);
}
