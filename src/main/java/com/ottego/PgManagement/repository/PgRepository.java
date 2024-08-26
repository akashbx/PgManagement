package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Pg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PgRepository extends JpaRepository<Pg, Integer> {

   List<Pg> findAllByOwner_id(Integer ownerId);
}
