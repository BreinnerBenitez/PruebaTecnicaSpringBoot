package com.pruebatecnica.tecnica.service;

import com.pruebatecnica.tecnica.dto.ProductoDTO;


import java.util.List;

public interface IProductoService {


    List<ProductoDTO> traerPoductos ();
    ProductoDTO crearSucursal(ProductoDTO PoductoDto);
    ProductoDTO actualizarSucursal(Long id, ProductoDTO productoDTO);
    void eliminarPoducto(Long id);
}
