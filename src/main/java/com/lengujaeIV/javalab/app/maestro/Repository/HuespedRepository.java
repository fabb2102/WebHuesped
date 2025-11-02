package com.lengujaeIV.javalab.app.maestro.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lengujaeIV.javalab.app.maestro.Entity.Huesped;
import java.util.List;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Integer> {

    
    List<Huesped> findByNombreContainingIgnoreCase(String nombre);
    
    List<Huesped> findByApellidoContainingIgnoreCase(String apellido);
    
    List<Huesped> findByDocumento(String documento);

    
    @Query("SELECT h FROM Huesped h WHERE " +
           "LOWER(h.nombre) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
           "LOWER(h.apellido) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
           "ORDER BY h.apellido ASC, h.nombre ASC")
    Page<Huesped> buscarPorFiltroJPQL(@Param("filtro") String filtro, Pageable pageable);

    
    @Query(value = "SELECT * FROM huesped WHERE " +
                   "LOWER(nacionalidad) LIKE LOWER(CONCAT('%', :nacionalidad, '%')) " +
                   "ORDER BY fecha_nacimiento DESC",
           countQuery = "SELECT COUNT(*) FROM huesped WHERE " +
                       "LOWER(nacionalidad) LIKE LOWER(CONCAT('%', :nacionalidad, '%'))",
           nativeQuery = true)
    Page<Huesped> buscarPorNacionalidadNativo(@Param("nacionalidad") String nacionalidad, Pageable pageable);
}