package com.pruebatecnica.tecnica.service;


import com.pruebatecnica.tecnica.dto.VentaDTO;

import java.util.List;

public interface IVentaService {


    List<VentaDTO> traerVentas ();
    VentaDTO crearSucursal(VentaDTO ventaDto);
    VentaDTO actualizarSucursal(Long id, VentaDTO sucrusalDTO);
    void eliminarVenta(Long id);


}
