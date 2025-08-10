package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.Dto.GuestDto;
import com.ottego.PgManagement.model.Guest;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    List<Guest> findByOwnerId(Integer ownerId);
    Optional<Guest> findByPhone(Long phone);


}
