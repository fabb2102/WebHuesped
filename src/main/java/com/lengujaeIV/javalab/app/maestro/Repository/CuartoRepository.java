package com.lengujaeIV.javalab.app.maestro.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lengujaeIV.javalab.app.maestro.Entity.Cuarto;
import java.util.List;

@Repository
public interface CuartoRepository extends JpaRepository<Cuarto, Integer> {


    
    List<Cuarto> findByNumeroCuarto(Integer numeroCuarto);
    
    List<Cuarto> findByTipoCuartoContainingIgnoreCase(String tipoCuarto);
    
    List<Cuarto> findByEstadoContainingIgnoreCase(String estado);

    
    @Query("SELECT c FROM Cuarto c WHERE " +
           "c.precioDiario BETWEEN :precioMin AND :precioMax " +
           "ORDER BY c.precioDiario ASC")
    Page<Cuarto> buscarPorRangoPrecioJPQL(
        @Param("precioMin") float precioMin,
        @Param("precioMax") float precioMax,
        Pageable pageable
    );

    
    @Query(value = "SELECT * FROM cuarto WHERE " +
                   "LOWER(estado) = LOWER(:estado) AND capacidad_maxima >= :capacidad " +
                   "ORDER BY numero_cuarto ASC",
           countQuery = "SELECT COUNT(*) FROM cuarto WHERE " +
                       "LOWER(estado) = LOWER(:estado) AND capacidad_maxima >= :capacidad",
           nativeQuery = true)
    Page<Cuarto> buscarDisponiblesPorCapacidadNativo(
        @Param("estado") String estado,
        @Param("capacidad") Integer capacidad,
        Pageable pageable
    );
}