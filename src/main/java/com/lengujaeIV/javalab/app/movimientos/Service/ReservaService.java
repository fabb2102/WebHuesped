package com.lengujaeIV.javalab.app.movimientos.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lengujaeIV.javalab.app.maestro.Entity.Huesped;
import com.lengujaeIV.javalab.app.maestro.Repository.HuespedRepository;
import com.lengujaeIV.javalab.app.movimientos.Entity.Reserva;
import com.lengujaeIV.javalab.app.movimientos.Repository.ReservaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository rRepository;
    
    @Autowired
    private HuespedRepository huespedRepository;
    

    
    public Reserva save(Reserva r) {
        System.out.println("===== DEBUG SAVE =====");
        System.out.println("Reserva recibida: " + r);
        
        if (r.getIdHuespedResponsable() != null) {
            System.out.println("Huesped responsable NO es null");
            System.out.println("ID del huesped: " + r.getIdHuespedResponsable().getIdHuesped());
            
            if (r.getIdHuespedResponsable().getIdHuesped() != null) {
                Integer idHuesped = r.getIdHuespedResponsable().getIdHuesped();
                System.out.println("Buscando huesped con ID: " + idHuesped);
                
                Huesped huesped = huespedRepository.findById(idHuesped)
                    .orElseThrow(() -> new EntityNotFoundException(
                        "Huésped no encontrado con ID: " + idHuesped));
                
                System.out.println("Huesped encontrado: " + huesped.getNombre() + " " + huesped.getApellido());
                r.setIdHuespedResponsable(huesped);
            } else {
                System.out.println("ERROR: idHuesped es NULL");
            }
        } else {
            System.out.println("ERROR: Huesped responsable es NULL");
        }
        
        Reserva saved = rRepository.save(r);
        System.out.println("Reserva guardada con ID: " + saved.getIdReserva());
        System.out.println("=====================");
        return saved;
    }
    
    public Reserva update(Reserva r) {
        if (r.getIdHuespedResponsable() != null && r.getIdHuespedResponsable().getIdHuesped() != null) {
            Huesped huesped = huespedRepository.findById(r.getIdHuespedResponsable().getIdHuesped())
                .orElseThrow(() -> new EntityNotFoundException(
                    "Huésped no encontrado con ID: " + r.getIdHuespedResponsable().getIdHuesped()));
            r.setIdHuespedResponsable(huesped);
        }
        return rRepository.save(r);
    }    
    
    public Reserva findById(Integer idR) {
        return rRepository.findById(idR)
            .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada con ID: " + idR));
    }
    
    public void delete(Integer idR) {
        if (!rRepository.existsById(idR)) {
            throw new EntityNotFoundException("Reserva no encontrada con ID: " + idR);
        }
        rRepository.deleteById(idR);
    }
    
    public List<Reserva> listar() {
        List<Reserva> r = new ArrayList<Reserva>();
        rRepository.findAll().forEach(r::add);
        return r;
    }
    
    public Page<Reserva> listarPaginado(Pageable pageable) {
        return rRepository.findAll(pageable);
    }
    

    
    public List<Reserva> findBySituacion(String situacion) {
        return rRepository.findBySituacion(situacion);
    }
    
    public List<Reserva> buscarPorHuesped(Integer idHuesped) {
        return rRepository.findByIdHuespedResponsable_IdHuesped(idHuesped);
    }
    
    public List<Reserva> buscarPorFecha(Date fecha) {
        return rRepository.findByFechaReserva(fecha);
    }

    
    public Page<Reserva> buscarPorRangoFechasJPQL(Date fechaInicio, Date fechaFin, Pageable pageable) {
        return rRepository.buscarPorRangoFechasJPQL(fechaInicio, fechaFin, pageable);
    }
    

    
    public Page<Reserva> buscarPorSituacionNativo(String situacion, Pageable pageable) {
        return rRepository.buscarPorSituacionNativo(situacion, pageable);
    }
    

    
    public List<Reserva> buscarReservas(String situacion) {
        return rRepository.buscarReservas(situacion);
    }
    
    public List<Reserva> buscarPorSituacion(String situacion, Pageable pageable) {
        return rRepository.buscarPorSituacion(situacion, pageable);
    }
    
    public List<Reserva> listaOrdenada(Sort sort) {
        List<Reserva> result = new ArrayList<Reserva>();
        rRepository.findAll(sort).forEach(result::add);
        return result;
    }
    
    public List<Reserva> findByHuespedNombre(String nombre) {
        return rRepository.findByHuespedNombreContainingIgnoreCase(nombre);
    }
    
    public Page<Reserva> findByHuespedNombre(String nombre, Pageable pageable) {
        return rRepository.findByHuespedNombreContainingIgnoreCase(nombre, pageable);
    }
}

