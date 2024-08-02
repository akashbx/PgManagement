package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {
    Bed findByName(String name);
}
