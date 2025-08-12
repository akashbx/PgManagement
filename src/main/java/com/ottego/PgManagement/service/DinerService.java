package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.DinerDto;
import com.ottego.PgManagement.Request.DinerRequest;
import com.ottego.PgManagement.model.Diner;
import com.ottego.PgManagement.model.Diner.DinerStatus;
import com.ottego.PgManagement.repository.DinerRepository;
import com.ottego.PgManagement.repository.MealRepository;
import com.ottego.PgManagement.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DinerService {
    @Autowired
    private DinerRepository dinerRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private StayRepository stayRepository;

    public List<DinerDto> getDiners(Integer stayId) {
        List<Diner> diners;

        if (stayId != null && stayId != 0) {
            diners = dinerRepository.findByStay_Id(stayId);
        } else {
            diners = dinerRepository.findAll();
        }

        return diners.stream()
                .map(DinerDto::from)
                .collect(Collectors.toList());
    }


    public DinerDto getDinerById(Integer id) {
        return dinerRepository.findById(id)
                .map(DinerDto::from)
                .orElseThrow(() -> new RuntimeException("Diner not found with id: " + id));
    }

    public void save(DinerRequest model) {
        Diner diner = new Diner();
        diner.setItem(model.getItem());
        diner.setPrice(model.getPrice());
        diner.setMeal(mealRepository.findById(model.getMeal_id())
                .orElseThrow(() -> new RuntimeException("Meal not found")));
        diner.setStay(stayRepository.findById(model.getStay_id())
                .orElseThrow(() -> new RuntimeException("Stay not found")));

        // Set status from request, default to REGISTERED if null
        diner.setStatus(model.getStatus() != null ? model.getStatus() : DinerStatus.REGISTERED);

        dinerRepository.save(diner);
    }

    public void update(DinerRequest request) {
        Diner diner = dinerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Diner not found with id: " + request.getId()));

        diner.setItem(request.getItem());
        diner.setPrice(request.getPrice());
        diner.setMeal(mealRepository.findById(request.getMeal_id())
                .orElseThrow(() -> new RuntimeException("Meal not found")));
        diner.setStay(stayRepository.findById(request.getStay_id())
                .orElseThrow(() -> new RuntimeException("Stay not found")));

        // Update status if provided
        if (request.getStatus() != null) {
            diner.setStatus(request.getStatus());
        }

        dinerRepository.save(diner);
    }

}
