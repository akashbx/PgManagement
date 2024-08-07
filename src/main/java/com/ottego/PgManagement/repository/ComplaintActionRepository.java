package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.ComplaintAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintActionRepository extends JpaRepository<ComplaintAction , Integer> {
}
