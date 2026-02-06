package com.pruebatecnica.tecnica.service;

import com.pruebatecnica.tecnica.dto.SucursalDTO;
import com.pruebatecnica.tecnica.model.Sucursal;

import java.util.List;

public interface ISucursalService {

List<SucursalDTO> traerSucursales ();
SucursalDTO crearSucursal(SucursalDTO sucursalDto);
SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO);
void eliminarSucursal(Long id);
}
