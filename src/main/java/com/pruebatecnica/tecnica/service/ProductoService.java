package com.pruebatecnica.tecnica.service;

import com.pruebatecnica.tecnica.dto.ProductoDTO;
import com.pruebatecnica.tecnica.dto.VentaDTO;
import com.pruebatecnica.tecnica.mapper.Mapper;
import com.pruebatecnica.tecnica.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService  implements  IProductoService{

    @Autowired
    private IProductoRepository repo;
    @Override
    public List<ProductoDTO> traerPoductos() {
        return  repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearSucursal(ProductoDTO PoductoDto) {
        return null;
    }

    @Override
    public ProductoDTO actualizarSucursal(Long id, ProductoDTO productoDTO) {
        return null;
    }

    @Override
    public void eliminarPoducto(Long id) {

    }
}
