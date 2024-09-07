package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.DishDto;
import com.ottego.PgManagement.Request.DishRequest;
import com.ottego.PgManagement.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public List<DishDto> getDish(@RequestParam(required = false) Integer pg_id) {
        return dishService.getDish(pg_id);
    }

    @GetMapping("/{id}")
    public DishDto getDishById(@PathVariable Integer id) {
        return dishService.getDishById(id);
    }

    @PostMapping
    public String addDish(@RequestBody DishRequest request) {
        dishService.save(request);
        return "Dish added successfully";
    }

    @PutMapping
    public String updateDish(@RequestBody DishRequest request) {
        dishService.update(request);
        return "Dish updated successfully";
    }
}
