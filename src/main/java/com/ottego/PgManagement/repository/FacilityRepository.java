package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility , Integer> {

}
