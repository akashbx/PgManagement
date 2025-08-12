package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.Dto.DinerDto;
import com.ottego.PgManagement.model.Diner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DinerRepository extends JpaRepository<Diner, Integer> {
    List<Diner> findByStay_Id(Integer stayId);

}
