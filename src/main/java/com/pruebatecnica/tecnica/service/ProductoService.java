package com.pruebatecnica.tecnica.service;

import com.pruebatecnica.tecnica.dto.ProductoDTO;
import com.pruebatecnica.tecnica.dto.VentaDTO;
import com.pruebatecnica.tecnica.exception.NotFoundException;
import com.pruebatecnica.tecnica.mapper.Mapper;
import com.pruebatecnica.tecnica.model.Producto;
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
    public ProductoDTO crearProducto(ProductoDTO ProductoDto) {
       var prod = Producto.builder()
               .nombre(ProductoDto.getNombre())
               .categoria(ProductoDto.getCategoria())
               .precio(ProductoDto.getPrecio())
               .cantidad(ProductoDto.getCantidad())
               .build();


        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {

        // buscar si existe en la base de datos
        Producto prod = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no existe"));
        prod.setNombre(productoDTO.getNombre());
        prod.setCategoria(productoDTO.getCategoria());
        prod.setCantidad(productoDTO.getCantidad());
        prod.setPrecio(productoDTO.getPrecio());

        return  Mapper.toDTO(repo.save(prod));
    }

    @Override
    public void eliminarPoducto(Long id) {
        if (!repo.existsById(id)){
            throw  new NotFoundException("Producto no encontrado para eliminarlo");
        }
        repo.deleteById(id);
    }
}
