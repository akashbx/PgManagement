package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findAllByPg_Id(Integer pgId);
    Meal findTopByPg_IdOrderByIdDesc(Integer pgId);
}
