package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
