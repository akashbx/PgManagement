package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.StayRequest;
import com.ottego.PgManagement.model.Stay;
import com.ottego.PgManagement.repository.StayRepository;
import com.ottego.PgManagement.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stay")
public class StayController {

    @Autowired
    private StayService stayService;



    @PostMapping
    public String addStay(@RequestBody StayRequest request) {
        stayService.save(request);
        return "Stay added successfully";
    }
}
