package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Caretaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaretakerRepository extends JpaRepository<Caretaker, Integer> {
    Optional<Caretaker> findByPhone(Long phone);
}
