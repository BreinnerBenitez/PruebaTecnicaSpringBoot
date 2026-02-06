package com.pruebatecnica.tecnica.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //venta
    @ManyToOne
    private Venta venta;
    //producto
    @ManyToOne
    private Producto pro;
    private Integer canProd;
    private Double precio;


}
