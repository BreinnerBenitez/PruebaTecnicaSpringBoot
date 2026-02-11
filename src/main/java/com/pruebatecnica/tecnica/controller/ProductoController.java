package com.pruebatecnica.tecnica.controller;

import com.pruebatecnica.tecnica.dto.ProductoDTO;
import com.pruebatecnica.tecnica.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> traerProductos (){

        return ResponseEntity.ok(productoService.traerPoductos());
    }
    @PostMapping
    public  ResponseEntity <ProductoDTO> crearProducto(@RequestBody ProductoDTO dto){

       ProductoDTO creado = productoService.crearProducto(dto);
        return  ResponseEntity.created(URI.create("/api/productos"+creado.getId())).body(creado);
    }

    @PutMapping("{id}")
    public ResponseEntity <ProductoDTO> actualziarProducto (@PathVariable Long id,
                                                            @RequestBody ProductoDTO dto){

        return  ResponseEntity.ok(productoService.actualizarProducto(id,dto));
    }

    @DeleteMapping ("{id}")
    public ResponseEntity <Void> borrarProducto (@PathVariable Long id){
        productoService.eliminarPoducto(id);
        return  ResponseEntity.noContent().build();
    }
}
