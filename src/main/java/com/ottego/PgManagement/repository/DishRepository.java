package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findAllByPg_id(Integer pgId);
}
