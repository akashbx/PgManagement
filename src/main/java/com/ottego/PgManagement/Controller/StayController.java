package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.StayDetails;
import com.ottego.PgManagement.Dto.StayWithBedRoom;
import com.ottego.PgManagement.Request.StayRequest;
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

    @GetMapping
    public List<StayDetails> getAllStays(@RequestParam (required = false) Integer bed_id) {
        return stayService.getAllStays(bed_id);
    }

    @PutMapping
    public String updateStay(@RequestBody StayRequest request) {
        stayService.update(request);
        return "Stay added successfully";
    }
    @GetMapping("/{id}")
    public StayDetails getStayById(@PathVariable Integer id) {
        return stayService.getStayById(id);
    }
    @GetMapping("/bed/{id}")
    public StayWithBedRoom StayWithBedRoom(@PathVariable Integer id) {
        return stayService.StayWithBedRoom(id);
    }

}
