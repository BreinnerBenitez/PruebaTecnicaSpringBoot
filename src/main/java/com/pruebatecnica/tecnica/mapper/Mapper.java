package com.pruebatecnica.tecnica.mapper;

import com.pruebatecnica.tecnica.dto.DetalleVentaDTO;
import com.pruebatecnica.tecnica.dto.SucursalDTO;
import com.pruebatecnica.tecnica.dto.VentaDTO;
import com.pruebatecnica.tecnica.model.Producto;
import com.pruebatecnica.tecnica.dto.ProductoDTO;
import com.pruebatecnica.tecnica.model.Sucursal;
import com.pruebatecnica.tecnica.model.Venta;

import java.util.stream.Collectors;


public class Mapper {

    // Mapeo d eprocuto a producto Dto

    public static ProductoDTO toDTO(Producto p) {

        if (p == null) return null;

        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .build();

    }


    // Mapeo de venta a ventaDTO
    public static VentaDTO toDTO(Venta venta) {
        if (venta == null) return null;

        var detalle = venta.getDetalle().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getPro().getId())
                        .nombreProd(det.getPro().getNombre())
                        .canProd(det.getCanProd())
                        .precio(det.getPrecio())
                        .subtotal(det.getPrecio() * det.getCanProd())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .idSucursal(venta.getSucursal().getId())
                .estado(venta.getEstado())
                .detalle(detalle)
                .total(total)
                .build();
    }


    // mapeo de Sucursal a SucursalDTO


    public static SucursalDTO toDTO(Sucursal s) {

        if (s == null) return null;

        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();

    }


}
