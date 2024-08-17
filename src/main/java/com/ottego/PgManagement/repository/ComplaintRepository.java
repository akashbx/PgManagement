package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
    List<Complaint> findAllByStay_Id(Integer stayId);
}
