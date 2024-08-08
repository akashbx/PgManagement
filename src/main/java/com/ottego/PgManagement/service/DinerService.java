package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.ComplaintDto;
import com.ottego.PgManagement.Dto.DinerDto;
import com.ottego.PgManagement.Request.DinerRequest;
import com.ottego.PgManagement.model.Diner;
import com.ottego.PgManagement.repository.DinerRepository;
import com.ottego.PgManagement.repository.MealRepository;
import com.ottego.PgManagement.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DinerService {
    @Autowired
    private DinerRepository dinerRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private StayRepository stayRepository;

    public List<DinerDto> getDiner() {
        return dinerRepository.findAll().stream().map(DinerDto::from).toList();
    }

    public void save(DinerRequest model) {
        Diner diner = new Diner();
        diner.setItem(model.getItem());
        diner.setPrice(model.getPrice());
        diner.setMeal(mealRepository.findById(model.getMealId()).get());
        diner.setStay(stayRepository.findById(model.getStayId()).get());
        dinerRepository.save(diner);
    }

    public void update(DinerRequest request) {
        Diner diner = dinerRepository.findById(request.getId()).get();
        diner.setItem(request.getItem());
        diner.setPrice(request.getPrice());
        diner.setMeal(mealRepository.findById(request.getMealId()).get());
        diner.setStay(stayRepository.findById(request.getStayId()).get());
        dinerRepository.save(diner);
    }

}
