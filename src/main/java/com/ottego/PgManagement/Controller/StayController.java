package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.StayDetails;
import com.ottego.PgManagement.Dto.StayDto;
import com.ottego.PgManagement.Dto.StayWithBedRoom;
import com.ottego.PgManagement.Request.StayRequest;
import com.ottego.PgManagement.model.Stay;
import com.ottego.PgManagement.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<StayDetails> getStays(
            @RequestParam(required = false) Integer bedId,
            @RequestParam(required = false) Integer guestId,
            @RequestParam(required = false) Integer pgId,
            @RequestParam(required = false) String status) {
        return stayService.getAllStays(bedId, guestId, pgId, status);
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

    @GetMapping("pg/{pg_id}")
    public List<StayDto> getAllStaysByPgId(@PathVariable Integer pg_id) {
        return stayService.getStayByPg_id(pg_id);
    }
    @GetMapping("{id}/total")
    public int getMonthlyMealCost(@PathVariable int id) {
        return stayService.calculateTotalCost(id);
    }
    @GetMapping("/getActiveStays")
    public List<StayWithBedRoom> getActiveStays() {
        return stayService.getActiveStays();
    }

//    @GetMapping("/{guest_id}")
//    public List<StayDetails> getStaysByGuest(@PathVariable Long guest_id) {
//        return stayService.getStaysByGuestId(guest_id);
//    }
}
