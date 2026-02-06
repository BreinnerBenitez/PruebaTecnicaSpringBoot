package com.pruebatecnica.tecnica.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDTO {
    // datos de la venta
    private Long id;
    private LocalDate fecha;
    private String estado;

    // datos de la sucursal

    private Long idSucursal;
    //lista de detallles
    private List<DetalleVentaDTO> detalle;
    //total venta
    private Double total;

}
