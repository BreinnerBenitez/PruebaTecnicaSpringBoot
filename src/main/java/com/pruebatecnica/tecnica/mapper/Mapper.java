package com.pruebatecnica.tecnica.mapper;

import com.pruebatecnica.tecnica.dto.SucursalDTO;
import com.pruebatecnica.tecnica.model.Producto;
import com.pruebatecnica.tecnica.dto.ProductoDTO;
import com.pruebatecnica.tecnica.model.Sucursal;


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
    public static SucursalDTO toDTO(Sucursal s) {

        if (s == null) return null;

        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();

    }

    // mapeo de Sucursal a SucursalDTO


}
