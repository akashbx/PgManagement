package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
