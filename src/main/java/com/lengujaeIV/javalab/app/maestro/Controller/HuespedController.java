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

import com.lengujaeIV.javalab.app.maestro.Entity.Huesped;
import com.lengujaeIV.javalab.app.maestro.Service.HuespedService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/huesped")
public class HuespedController {
    
    @Autowired
    private HuespedService hService;
    

    
    @GetMapping("/mostrar")
    public List<Huesped> listar() {
        return hService.listar();
    }
    
    @GetMapping("/buscar/{id}")
    public Huesped buscar(@PathVariable("id") Integer idH) {
        return hService.findById(idH);
    }
    
    @PostMapping("/guardar")
    public Huesped guardar(@Valid @RequestBody Huesped h) {
        return hService.save(h);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Huesped> actualizar(@PathVariable("id") Integer idH, @RequestBody Huesped h) {
        h.setIdHuesped(idH);
        Huesped hActualizada = hService.update(h);
        return new ResponseEntity<>(hActualizada, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer idH) {
        hService.delete(idH);
        return new ResponseEntity<>("Huesped eliminado", HttpStatus.OK);
    }

    
    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<Huesped>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(hService.buscarPorNombre(nombre));
    }
    
    @GetMapping("/buscar/apellido")
    public ResponseEntity<List<Huesped>> buscarPorApellido(@RequestParam String apellido) {
        return ResponseEntity.ok(hService.buscarPorApellido(apellido));
    }
    
    @GetMapping("/buscar/documento")
    public ResponseEntity<List<Huesped>> buscarPorDocumento(@RequestParam String documento) {
        return ResponseEntity.ok(hService.buscarPorDocumento(documento));
    }
    

    
    @GetMapping("/buscar/filtro-jpql")
    public ResponseEntity<Page<Huesped>> buscarPorFiltroJPQL(
            @RequestParam String filtro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(hService.buscarPorFiltroJPQL(filtro, pageable));
    }
    

    
    @GetMapping("/buscar/nacionalidad-nativo")
    public ResponseEntity<Page<Huesped>> buscarPorNacionalidadNativo(
            @RequestParam String nacionalidad,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(hService.buscarPorNacionalidadNativo(nacionalidad, pageable));
    }
}