package com.pruebatecnica.tecnica.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVentaDTO {

    private long id;
    private String nombreProd;
    private Integer canProd;
    private Double precio;
    private Double subtotal;
}
