package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Integer> {

    List<Stay> findAllByBed_Id(Integer bed_id);
}
