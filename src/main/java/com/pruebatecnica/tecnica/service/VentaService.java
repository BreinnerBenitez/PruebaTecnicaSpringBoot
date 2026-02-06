package com.pruebatecnica.tecnica.service;

import com.pruebatecnica.tecnica.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Override
    public List<VentaDTO> traerVentas() {
        return List.of();
    }

    @Override
    public VentaDTO crearSucursal(VentaDTO ventaDto) {
        return null;
    }

    @Override
    public VentaDTO actualizarSucursal(Long id, VentaDTO sucrusalDTO) {
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

    }
}
