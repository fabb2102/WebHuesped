package com.lengujaeIV.javalab.app.maestro.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lengujaeIV.javalab.app.maestro.Entity.Huesped;
import com.lengujaeIV.javalab.app.maestro.Repository.HuespedRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HuespedService {
    
    @Autowired
    private HuespedRepository hRepository;
    

    
    public Huesped save(Huesped h) {
        return hRepository.save(h);
    }
    
    public Huesped update(Huesped h) {
        return hRepository.save(h);
    }    
    
    public Huesped findById(Integer idH) {
        return hRepository.findById(idH)
            .orElseThrow(() -> new EntityNotFoundException("Huésped no encontrado con ID: " + idH));
    }
    
    public void delete(Integer idH) {
        if (!hRepository.existsById(idH)) {
            throw new EntityNotFoundException("Huésped no encontrado con ID: " + idH);
        }
        hRepository.deleteById(idH);
    }
    
    public List<Huesped> listar() {
        List<Huesped> h = new ArrayList<Huesped>();
        hRepository.findAll().forEach(h::add);
        return h;
    }
    

    
    public List<Huesped> buscarPorNombre(String nombre) {
        return hRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    public List<Huesped> buscarPorApellido(String apellido) {
        return hRepository.findByApellidoContainingIgnoreCase(apellido);
    }
    
    public List<Huesped> buscarPorDocumento(String documento) {
        return hRepository.findByDocumento(documento);
    }
    

    
    public Page<Huesped> buscarPorFiltroJPQL(String filtro, Pageable pageable) {
        return hRepository.buscarPorFiltroJPQL(filtro, pageable);
    }
    

    
    public Page<Huesped> buscarPorNacionalidadNativo(String nacionalidad, Pageable pageable) {
        return hRepository.buscarPorNacionalidadNativo(nacionalidad, pageable);
    }
}
