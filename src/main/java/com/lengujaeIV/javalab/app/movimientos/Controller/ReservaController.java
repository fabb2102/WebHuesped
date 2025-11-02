package com.lengujaeIV.javalab.app.movimientos.Controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lengujaeIV.javalab.app.movimientos.Entity.Reserva;
import com.lengujaeIV.javalab.app.movimientos.Service.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/reserva")
public class ReservaController {
    
    @Autowired
    private ReservaService rService;
    

    
    @GetMapping("/listar")
    public List<Reserva> listar() {
        return rService.listar();
    }
    
    @GetMapping("/buscar/{id}")
    public Reserva buscar(@PathVariable("id") Integer idR) {
        return rService.findById(idR);
    }
    
    @PostMapping("/guardar")
    public Reserva guardar(@Valid @RequestBody Reserva r) {
        r.setIdReserva(null);
        return rService.save(r);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable("id") Integer idR, @RequestBody Reserva r) {
        r.setIdReserva(idR);
        Reserva rActualizada = rService.update(r);
        return new ResponseEntity<>(rActualizada, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer idR) {
        rService.delete(idR);
        return new ResponseEntity<>("Reserva eliminada", HttpStatus.OK);
    }

    
    @GetMapping("/listar-paginado")
    public Map<String, Object> listarPaginado(Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        result.put("list", rService.listarPaginado(pageable).getContent());
        return result;
    }
    
    @GetMapping("/listar-ordenado")
    public Map<String, Object> listarOrdenado(
            @RequestParam(defaultValue = "idReserva") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            Sort.Direction sortDirection = Sort.Direction.fromString(direction);
            Sort sortObj = Sort.by(sortDirection, sort);
            
            result.put("ok", true);
            result.put("list", rService.listaOrdenada(sortObj));
            result.put("propiedad_usada", sort);
            result.put("direccion", direction);
            
        } catch (Exception e) {
            result.put("ok", false);
            result.put("error", "Error: " + e.getMessage());
            result.put("sugerencia", "Usa propiedades como: idReserva, situacion, fecha_reserva");
        }
        
        return result;
    }
    
    @GetMapping("/buscar-por-situacion/{situacion}")
    public List<Reserva> buscarReservas(@PathVariable("situacion") String situacion) {
        return rService.findBySituacion(situacion);
    }
    
    @GetMapping("/buscar-situacion-ignore-case-page")
    public List<Reserva> buscarReservasPaginado(
            @RequestParam String situacion,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return rService.buscarPorSituacion(situacion, pageable);
    }
    
    @GetMapping("/buscar-por-huesped")
    public Map<String, Object> buscarPorHuespedNombre(
            @RequestParam String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            if (page == 0 && size == 10) {
                // Sin paginación
                List<Reserva> reservas = rService.findByHuespedNombre(nombre);
                result.put("ok", true);
                result.put("list", reservas);
                result.put("total", reservas.size());
            } else {
                // Con paginación
                Pageable pageable = PageRequest.of(page, size);
                Page<Reserva> reservasPage = rService.findByHuespedNombre(nombre, pageable);
                
                result.put("ok", true);
                result.put("list", reservasPage.getContent());
                result.put("total", reservasPage.getTotalElements());
                result.put("paginas", reservasPage.getTotalPages());
                result.put("pagina_actual", page);
            }
            
        } catch (Exception e) {
            result.put("ok", false);
            result.put("error", e.getMessage());
        }
        
        return result;
    }
    
    @GetMapping("/buscar-por-huesped-responsable/{idHuesped}")
    public ResponseEntity<List<Reserva>> buscarPorHuespedResponsable(@PathVariable Integer idHuesped) {
        return ResponseEntity.ok(rService.buscarPorHuesped(idHuesped));
    }
    
    @GetMapping("/buscar-por-fecha")
    public ResponseEntity<List<Reserva>> buscarPorFecha(@RequestParam String fecha) {
        try {
            Date fechaSQL = Date.valueOf(fecha); // Formato esperado: "2025-11-01"
            return ResponseEntity.ok(rService.buscarPorFecha(fechaSQL));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    

    
    @GetMapping("/buscar/rango-fechas-jpql")
    public ResponseEntity<Page<Reserva>> buscarPorRangoFechasJPQL(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        try {
            Date fechaInicioSQL = Date.valueOf(fechaInicio);
            Date fechaFinSQL = Date.valueOf(fechaFin);
            Pageable pageable = PageRequest.of(page, size);
            return ResponseEntity.ok(rService.buscarPorRangoFechasJPQL(fechaInicioSQL, fechaFinSQL, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    

    
    @GetMapping("/buscar/situacion-nativo")
    public ResponseEntity<Page<Reserva>> buscarPorSituacionNativo(
            @RequestParam String situacion,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(rService.buscarPorSituacionNativo(situacion, pageable));
    }
}
