package com.pruebatecnica.tecnica.service;

import com.pruebatecnica.tecnica.dto.SucursalDTO;
import com.pruebatecnica.tecnica.exception.NotFoundException;
import com.pruebatecnica.tecnica.mapper.Mapper;
import com.pruebatecnica.tecnica.model.Sucursal;
import com.pruebatecnica.tecnica.repository.ISucursalRepository;
import org.hibernate.engine.jdbc.cursor.internal.StandardRefCursorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private ISucursalRepository repo;

    @Override
    public List<SucursalDTO> traerSucursales() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDto) {

        Sucursal suc = Sucursal.builder()
                .nombre(sucursalDto.getNombre())
                .direccion(sucursalDto.getDireccion())
                .build();

        return Mapper.toDTO(repo.save(suc));
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO) {

        Sucursal suc = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Sucrusal no encontrada"));
        suc.setNombre(sucursalDTO.getNombre());
        suc.setDireccion(sucursalDTO.getDireccion());

        return Mapper.toDTO(repo.save(suc));
    }

    @Override
    public void eliminarSucursal(Long id) {

        if (!repo.existsById(id)) {
            throw new NotFoundException("Sucursal no encontrado para eliminarlo");
        }
        repo.deleteById(id);

    }
}
