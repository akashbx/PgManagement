package com.ottego.PgManagement.repository;


import com.ottego.PgManagement.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Integer> {

    List<Stay> findAllByBed_Id(Integer bed_id);

    @Query("SELECT c FROM Stay c WHERE c.bed.room.pg.id = :pg_id")
    List<Stay> findBySuperParentId(@Param("pg_id") Integer pg_id);

}
