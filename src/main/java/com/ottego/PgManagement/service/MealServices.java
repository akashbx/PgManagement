package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.MealDetail;
import com.ottego.PgManagement.Dto.MealDto;
import com.ottego.PgManagement.Request.MealRequest;
import com.ottego.PgManagement.model.Dish;
import com.ottego.PgManagement.model.Enum.MealType;
import com.ottego.PgManagement.model.Meal;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.repository.DishRepository;
import com.ottego.PgManagement.repository.MealRepository;
import com.ottego.PgManagement.repository.PgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServices {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private PgRepository pgRepository;
    @Autowired
    private DishRepository dishRepository;

    public List<MealDto> getMeal() {
        return mealRepository.findAll().stream().map(MealDto::from).toList();
    }

    public MealDetail getMealDetail(Integer id) {
        Meal meal = mealRepository.findById(id).get();
        MealDetail mealDetail = MealDetail.from(meal);
        return mealDetail;
    }

    public void save(MealRequest model){
        Meal meal = new Meal();

        meal.setType(MealType.valueOf(model.getType()));
        model.getPg_id();
        model.getDish_ids();

        Pg pg = pgRepository.findById(model.getPg_id()).get();
        List<Dish> dish = dishRepository.findAllById(model.getDish_ids());
        meal.setPg(pg);
        meal.setDishes(dish);
        mealRepository.save(meal);
    }

    public void update(MealRequest request){
        Meal meal = mealRepository.findById(request.getId()).get();

        meal.setType(MealType.valueOf(request.getType()));
        request.getPg_id();
        request.getDish_ids();
        Pg pg = pgRepository.findById(request.getPg_id()).get();
        List<Dish> dish = dishRepository.findAllById(request.getDish_ids());
        meal.setPg(pg);
        meal.setDishes(dish);
        mealRepository.save(meal);
    }
}
