package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
}
