package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.BedDetail;
import com.ottego.PgManagement.Dto.BedWithStay;
import com.ottego.PgManagement.Request.BedRequest;
import com.ottego.PgManagement.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bed")
public class BedController {
    @Autowired
    private BedService bedService;


    @GetMapping
    public List<BedWithStay> getBeds (@RequestParam (required = false) Integer room_id) {
        return bedService.getBeds(room_id);
    }

    @PostMapping
    public String addBed(@RequestBody BedRequest bed) {
        bedService.save(bed);
        return "Bed added successfully";
    }

    @PutMapping
    public String updateBed(@RequestBody BedRequest bed) {
        bedService.update(bed);
        return "Bed added successfully";
    }
    @GetMapping("/{Id}")
    public BedWithStay getBedById(@PathVariable Integer Id) {
        return bedService.getBedById(Id);
    }
    @GetMapping("/count/{Id}")
    public BedDetail getBedDetail(@PathVariable Integer Id) {
        return bedService.getBedDetailsById(Id);
    }
}
