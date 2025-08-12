package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.DinerDto;
import com.ottego.PgManagement.Request.DinerRequest;
import com.ottego.PgManagement.model.Diner;
import com.ottego.PgManagement.service.DinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/diner")
public class DinerController {
    @Autowired
    private DinerService dinerService;

    @GetMapping
    public List<DinerDto> getDiners() {
        return dinerService.getDiner();
    }

    @GetMapping("/{id}")
    public DinerDto getDinerById(@PathVariable Integer id) {
        return dinerService.getDinerById(id);
    }


    @PostMapping
    public String addDiner(@RequestBody DinerRequest request) {
        dinerService.save(request);
        return "Diner added successfully";
    }
    @PutMapping
    public String updateDiner(@RequestBody DinerRequest request) {
        dinerService.update(request);
        return "Diner updated successfully";
    }
    @GetMapping("/stay/{stayId}")
    public List<DinerDto> getDinersByStayId(@PathVariable Long stayId) {
        return dinerService.getDinersByStayId(stayId);
    }
}
