package com.lengujaeIV.javalab.app.movimientos.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lengujaeIV.javalab.app.movimientos.Entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findBySituacion(String situacion);
    
    List<Reserva> findByIdHuespedResponsable_IdHuesped(Integer idHuesped);
    
    List<Reserva> findByFechaReserva(Date fechaReserva);

    
    @Query("SELECT r FROM Reserva r WHERE " +
           "r.fechaInicio BETWEEN :fechaInicio AND :fechaFin " +
           "ORDER BY r.fechaReserva DESC")
    Page<Reserva> buscarPorRangoFechasJPQL(
        @Param("fechaInicio") Date fechaInicio,
        @Param("fechaFin") Date fechaFin,
        Pageable pageable
    );

    
    @Query(value = "SELECT * FROM reserva WHERE " +
                   "LOWER(situacion) = LOWER(:situacion) " +
                   "ORDER BY fecha_reserva DESC",
           countQuery = "SELECT COUNT(*) FROM reserva WHERE " +
                       "LOWER(situacion) = LOWER(:situacion)",
           nativeQuery = true)
    Page<Reserva> buscarPorSituacionNativo(@Param("situacion") String situacion, Pageable pageable);
    

    
    @Query("SELECT r FROM Reserva r WHERE LOWER(r.situacion)= LOWER(:situacion)")
    List<Reserva> buscarReservas(String situacion);
    
    @Query("SELECT r FROM Reserva r WHERE r.situacion= :situacion")
    List<Reserva> buscarPorSituacion(@Param("situacion")  String situacion, Pageable pageable);
    
    @Query("SELECT r FROM Reserva r JOIN r.idHuespedResponsable h WHERE LOWER(h.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Reserva> findByHuespedNombreContainingIgnoreCase(@Param("nombre") String nombre);
    
    @Query("SELECT r FROM Reserva r JOIN r.idHuespedResponsable h WHERE LOWER(h.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    Page<Reserva> findByHuespedNombreContainingIgnoreCase(@Param("nombre") String nombre, Pageable pageable);
}
