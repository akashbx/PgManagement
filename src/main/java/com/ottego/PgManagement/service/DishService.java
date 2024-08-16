package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.ComplaintDto;
import com.ottego.PgManagement.Dto.DishDto;
import com.ottego.PgManagement.Request.DishRequest;
import com.ottego.PgManagement.model.Dish;
import com.ottego.PgManagement.model.Enum.Cuisine;
import com.ottego.PgManagement.repository.DishRepository;
import com.ottego.PgManagement.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private MealRepository mealRepository;

    public List<DishDto> getDish() {
        return dishRepository.findAll().stream().map(DishDto::from).toList();
    }

    public DishDto getDishById(Integer id) {
        return DishDto.from(dishRepository.findById(id).get());
    }
    public void save(DishRequest model) {
        Dish dish = new Dish();
        dish.setCuisine(Cuisine.valueOf(model.getCuisine()));
        dish.setName(model.getName());
        dish.setDescription(model.getDescription());
        dish.setPrice(model.getPrice());
        dishRepository.save(dish);
    }
    public void update(DishRequest request) {
        Dish dish = dishRepository.findById(request.getId()).get();
        dish.setCuisine(Cuisine.valueOf(request.getCuisine()));
        dish.setName(request.getName());
        dish.setDescription(request.getDescription());
        dish.setPrice(request.getPrice());
        dishRepository.save(dish);
    }
}
