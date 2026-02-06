package com.pruebatecnica.tecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDTO {

    private long id;
    private String nombreProd;
    private Integer canProd;
    private Double precio;
    private Double subtotal;
}
