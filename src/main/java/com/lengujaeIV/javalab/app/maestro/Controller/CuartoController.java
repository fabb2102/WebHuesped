package com.lengujaeIV.javalab.app.maestro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.lengujaeIV.javalab.app.maestro.Entity.Cuarto;
import com.lengujaeIV.javalab.app.maestro.Service.CuartoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/cuarto")
public class CuartoController {
    
    @Autowired
    private CuartoService cService;

    
    @GetMapping("/listar")
    public List<Cuarto> listar() {
        return cService.listar();
    }
    
    @GetMapping("/buscar/{id}")
    public Cuarto buscar(@PathVariable("id") Integer idC) {
        return cService.findById(idC);
    }
    
    @PostMapping("/guardar")
    public Cuarto guardar(@Valid @RequestBody Cuarto c) {
        return cService.save(c);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cuarto> actualizar(@PathVariable("id") Integer idC, @RequestBody Cuarto c) {
        c.setIdCuarto(idC);
        Cuarto cActualizada = cService.update(c);
        return new ResponseEntity<>(cActualizada, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer idC) {
        cService.delete(idC);
        return new ResponseEntity<>("Cuarto eliminado", HttpStatus.OK);
    }
    

    
    @GetMapping("/buscar/numero")
    public ResponseEntity<List<Cuarto>> buscarPorNumero(@RequestParam Integer numero) {
        return ResponseEntity.ok(cService.buscarPorNumero(numero));
    }
    
    @GetMapping("/buscar/tipo")
    public ResponseEntity<List<Cuarto>> buscarPorTipo(@RequestParam String tipo) {
        return ResponseEntity.ok(cService.buscarPorTipo(tipo));
    }
    
    @GetMapping("/buscar/estado")
    public ResponseEntity<List<Cuarto>> buscarPorEstado(@RequestParam String estado) {
        return ResponseEntity.ok(cService.buscarPorEstado(estado));
    }

    
    @GetMapping("/buscar/precio-jpql")
    public ResponseEntity<Page<Cuarto>> buscarPorRangoPrecioJPQL(
            @RequestParam float precioMin,
            @RequestParam float precioMax,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(cService.buscarPorRangoPrecioJPQL(precioMin, precioMax, pageable));
    }
    

    
    @GetMapping("/buscar/disponibles-nativo")
    public ResponseEntity<Page<Cuarto>> buscarDisponiblesPorCapacidadNativo(
            @RequestParam String estado,
            @RequestParam Integer capacidad,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(cService.buscarDisponiblesPorCapacidadNativo(estado, capacidad, pageable));
    }
}