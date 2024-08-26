package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    List<Complaint> findAllByStay_Id(Integer stayId);

    List<Complaint> findAllByStay_Bed_Room_Pg_Id(Integer pgId);

}
