package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Pg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PgRepository extends JpaRepository<Pg, Integer> {
    @Override
    Optional<Pg> findById(Integer id);
}
