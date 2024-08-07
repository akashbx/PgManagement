package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Diner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinerRepository extends JpaRepository<Diner, Integer> {
}
