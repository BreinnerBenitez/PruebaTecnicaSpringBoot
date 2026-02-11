package com.pruebatecnica.tecnica.service;


import com.pruebatecnica.tecnica.dto.VentaDTO;

import java.util.List;

public interface IVentaService {


    List<VentaDTO> traerVentas ();
    VentaDTO crearVenta(VentaDTO ventaDto);
    VentaDTO actualizarVenta(Long id, VentaDTO ventaDTO);
    void eliminarVenta(Long id);


}
