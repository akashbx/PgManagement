package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.PgDto;
import com.ottego.PgManagement.Dto.PgWithRooms;
import com.ottego.PgManagement.Request.PgRequest;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.model.PgDetails;
import com.ottego.PgManagement.service.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pg")
public class PgController {

    @Autowired
    private PgService pgService;



    @GetMapping()
    public List<PgDto> getAllPgs() {
        return pgService.getAllPgs();
    }
    @GetMapping("all")
    public List<PgWithRooms> getAllPgsWithRooms() {
        return pgService.getAllPgsWithRooms();
    }
    @GetMapping("{id}")
    public PgDetails getPgDetails(@PathVariable("id") Integer id) {
        return pgService.getPgDetails(id);
    }


    @PostMapping()
    public String addPg(@RequestBody PgRequest Request) {
        pgService.save(Request);
        return "pg added successfully";
    }
    @PutMapping()
    public String updatePg(@RequestBody PgRequest Request) {
        pgService.update(Request);
        return "pg updated successfully";
    }
}
