package com.lengujaeIV.javalab.app.maestro.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lengujaeIV.javalab.app.maestro.Entity.Cuarto;
import com.lengujaeIV.javalab.app.maestro.Repository.CuartoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CuartoService {
    
    @Autowired
    private CuartoRepository cRepository;
    

    
    public Cuarto save(Cuarto c) {
        return cRepository.save(c);
    }
    
    public Cuarto update(Cuarto c) {
        return cRepository.save(c);
    }    
    
    public Cuarto findById(Integer idC) {
        return cRepository.findById(idC)
            .orElseThrow(() -> new EntityNotFoundException("Cuarto no encontrado con ID: " + idC));
    }
    
    public void delete(Integer idC) {
        if (!cRepository.existsById(idC)) {
            throw new EntityNotFoundException("Cuarto no encontrado con ID: " + idC);
        }
        cRepository.deleteById(idC);
    }
    
    public List<Cuarto> listar() {
        List<Cuarto> c = new ArrayList<Cuarto>();
        cRepository.findAll().forEach(c::add);
        return c;
    }
    

    
    public List<Cuarto> buscarPorNumero(Integer numero) {
        return cRepository.findByNumeroCuarto(numero);
    }
    
    public List<Cuarto> buscarPorTipo(String tipo) {
        return cRepository.findByTipoCuartoContainingIgnoreCase(tipo);
    }
    
    public List<Cuarto> buscarPorEstado(String estado) {
        return cRepository.findByEstadoContainingIgnoreCase(estado);
    }
    

    
    public Page<Cuarto> buscarPorRangoPrecioJPQL(float precioMin, float precioMax, Pageable pageable) {
        return cRepository.buscarPorRangoPrecioJPQL(precioMin, precioMax, pageable);
    }
    

    
    public Page<Cuarto> buscarDisponiblesPorCapacidadNativo(String estado, Integer capacidad, Pageable pageable) {
        return cRepository.buscarDisponiblesPorCapacidadNativo(estado, capacidad, pageable);
    }
}
