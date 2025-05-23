package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.MealDetail;
import com.ottego.PgManagement.Dto.MealDto;
import com.ottego.PgManagement.Request.MealRequest;
import com.ottego.PgManagement.service.MealServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meal")
public class MealController {
    @Autowired
    private MealServices mealService;

    @GetMapping
    public List<MealDto> getMeals(@RequestParam(required = false) Integer pg_id) {
        return mealService.getMeals(pg_id);
    }

    @GetMapping("/{id}")
    public MealDetail getMealDetail(@PathVariable Integer id) {
        return mealService.getMealDetail(id);
    }
    @GetMapping("/latest")
    public MealDetail getLastMealDetail(@RequestParam Integer pg_id) {
        return mealService.getLatestMeal(pg_id);
    }

    @PostMapping
    public String addMeal(@RequestBody MealRequest request) {
        mealService.save(request);
        return "Meal added successfully";
    }

    @PutMapping
    public String updateMeal(@RequestBody MealRequest request) {
        mealService.update(request);
        return "Meal updated successfully";
    }
}
