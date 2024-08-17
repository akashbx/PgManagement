package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {
    Bed findByName(String name);

    long countBedsByRoomId(Integer roomId);

    List<Bed> findBedByRoom_id(Integer roomId);
}
