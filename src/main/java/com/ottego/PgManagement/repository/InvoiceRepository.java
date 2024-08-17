package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findAllByStay_Id(Integer stayId);
}
