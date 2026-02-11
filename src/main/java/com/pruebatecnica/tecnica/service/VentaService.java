package com.pruebatecnica.tecnica.service;

import com.pruebatecnica.tecnica.dto.DetalleVentaDTO;
import com.pruebatecnica.tecnica.dto.VentaDTO;
import com.pruebatecnica.tecnica.exception.NotFoundException;
import com.pruebatecnica.tecnica.mapper.Mapper;
import com.pruebatecnica.tecnica.model.DetalleVenta;
import com.pruebatecnica.tecnica.model.Producto;
import com.pruebatecnica.tecnica.model.Sucursal;
import com.pruebatecnica.tecnica.model.Venta;
import com.pruebatecnica.tecnica.repository.IProductoRepository;
import com.pruebatecnica.tecnica.repository.ISucursalRepository;
import com.pruebatecnica.tecnica.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoRepository productoRepo;
    @Autowired
    private ISucursalRepository sucursalRepo;


    @Override
    public List<VentaDTO> traerVentas() {
        VentaDTO dto;
        List<Venta> ventas = ventaRepo.findAll();
        List<VentaDTO> ventaDto = new ArrayList<>();

        for (Venta v : ventas) {
            dto = Mapper.toDTO(v);
            ventaDto.add(dto);

        }
        return ventaDto;
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDto) {

        //Validaciones
        if (ventaDto == null) throw new RuntimeException("VentaDTO es null");
        if (ventaDto.getIdSucursal() == null) throw new RuntimeException("Debe indicar la sucursal");
        if (ventaDto.getDetalle() == null || ventaDto.getDetalle().isEmpty())
            throw new RuntimeException("Debe incluir al menos un producto");

        //Buscar la sucursal
        Sucursal suc = sucursalRepo.findById(ventaDto.getIdSucursal()).orElse(null);
        if (suc == null) {
            throw new NotFoundException("Sucursal no encontrada");
        }

        //Crear la venta
        Venta vent = new Venta();
        vent.setFecha(ventaDto.getFecha());
        vent.setEstado(ventaDto.getEstado());
        vent.setSucursal(suc);
        vent.setTotal(ventaDto.getTotal());

        // La lista de detalles
        // --> Acá están los productos
        List<DetalleVenta> detalles = new ArrayList<>();
        Double totalCalculado = 0.0;

        for (DetalleVentaDTO detDTO : ventaDto.getDetalle()) {
            // Buscar producto por id (tu detDTO usa id como id de producto)
            Producto p = productoRepo.findByNombre(detDTO.getNombreProd()).orElse(null);
            if (p == null) {
                throw new RuntimeException("Producto no encontrado: " + detDTO.getNombreProd());
            }
            //Crear detalle
            DetalleVenta detalleVent = new DetalleVenta();
            detalleVent.setPro(p);
            detalleVent.setPrecio(detDTO.getPrecio());
            detalleVent.setCanProd(detDTO.getCanProd());
            detalleVent.setVenta(vent);

            detalles.add(detalleVent);
            totalCalculado = totalCalculado + (detDTO.getPrecio() * detDTO.getCanProd());


        }
        //Seteamos la lista de detalle Venta
        vent.setDetalle(detalles);

        //guardamos en la BD
        vent = ventaRepo.save(vent);

        //Mapeo de salida
        VentaDTO ventaSalida = Mapper.toDTO(vent);

        return ventaSalida;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO sucrusalDTO) {
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

    }

}
