package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.FacilityDto;
import com.ottego.PgManagement.Request.FacilityRequest;
import com.ottego.PgManagement.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @GetMapping
    public List<FacilityDto> getAllFacilities() {
        return facilityService.getFacilities();
    }

    @PostMapping
    public String addFacility(@RequestBody FacilityRequest facility) {
        facilityService.save(facility);
        return "Facility added successfully";
    }

    @PutMapping
    public String updateFacility(@RequestBody FacilityRequest facility) {
        facilityService.update(facility);
        return "Facility added successfully";
    }
}
