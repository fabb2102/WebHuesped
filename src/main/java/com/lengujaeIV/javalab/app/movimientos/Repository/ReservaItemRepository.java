package com.lengujaeIV.javalab.app.movimientos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lengujaeIV.javalab.app.movimientos.Entity.ReservaItem;

@Repository
public interface ReservaItemRepository extends JpaRepository<ReservaItem, Integer> {

}
