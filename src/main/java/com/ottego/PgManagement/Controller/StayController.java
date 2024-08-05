package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Request.StayRequest;
import com.ottego.PgManagement.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
