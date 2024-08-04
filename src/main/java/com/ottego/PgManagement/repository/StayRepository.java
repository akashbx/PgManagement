package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StayRepository extends JpaRepository<Stay, Integer> {

}
