package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.ComplaintDto;
import com.ottego.PgManagement.Dto.DishDto;
import com.ottego.PgManagement.Dto.PgDto;
import com.ottego.PgManagement.Request.DishRequest;
import com.ottego.PgManagement.model.Dish;
import com.ottego.PgManagement.model.Enum.Cuisine;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.repository.DishRepository;
import com.ottego.PgManagement.repository.MealRepository;
import com.ottego.PgManagement.repository.PgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private PgRepository pgRepository;

    public List<DishDto> getDish(Integer pg_id) {
        if (pg_id != null && pg_id != 0) {
            return dishRepository.findAllByPg_id(pg_id).stream().map(DishDto::from).toList();
        }else {
            return dishRepository.findAll().stream().map(DishDto::from).toList();
        }
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
        model.getPg_id();
        Pg pg = pgRepository.findById(model.getPg_id()).get();
        dish.setPg(pg);
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
