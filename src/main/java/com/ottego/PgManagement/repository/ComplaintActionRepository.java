package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.ComplaintAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ComplaintActionRepository extends JpaRepository<ComplaintAction , Integer> {
    List<ComplaintAction> findAllByComplaint_Id(Integer complaintId);
}
