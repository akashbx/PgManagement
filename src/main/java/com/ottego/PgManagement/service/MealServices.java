package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.MealDetail;
import com.ottego.PgManagement.Request.MealRequest;
import com.ottego.PgManagement.model.Enum.MealType;
import com.ottego.PgManagement.model.Meal;
import com.ottego.PgManagement.model.Pg;
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

    public List<MealDetail> getMeal() {
        return mealRepository.findAll().stream().map(MealDetail::from).toList();
    }

    public void save(MealRequest model){
        Meal meal = new Meal();

        meal.setType(MealType.valueOf(model.getType()));
        model.getPgId();

        Pg pg = pgRepository.findById(model.getPgId()).get();
        meal.setPg(pg);
        mealRepository.save(meal);
    }

    public void update(MealRequest request){
        Meal meal = mealRepository.findById(request.getId()).get();

        meal.setType(MealType.valueOf(request.getType()));
        request.getPgId();
        Pg pg = pgRepository.findById(request.getPgId()).get();
        meal.setPg(pg);
        mealRepository.save(meal);
    }
}
