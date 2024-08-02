package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.service.PgServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pg")
public class PgController {

    @Autowired
    private PgServices pgService;



    @GetMapping()
    public List<Pg> getAllPgs() {
        return pgService.getAllPgs();
    }

    @GetMapping("{id}")
    public Pg getPgDetails(@PathVariable("id") Integer id) {
        return pgService.getPgDetails(id);
    }


    @PostMapping()
    public String addPg(@RequestBody PgRequest pgRequest) {
        return pgService.addPg(
                pgRequest.getId(),
                pgRequest.getName(),
                pgRequest.getAddress(),
                pgRequest.getCity(),
                pgRequest.getState(),
                pgRequest.getZip(),
                pgRequest.getPhone(),
                pgRequest.getCaretaker()
        );
    }
    @PutMapping()
    public String updatePg(@RequestBody PgRequest pgRequest) {
        return pgService.updatePg(
                pgRequest.getId(),
                pgRequest.getName(),
                pgRequest.getAddress(),
                pgRequest.getCity(),
                pgRequest.getState(),
                pgRequest.getZip(),
                pgRequest.getPhone(),
                pgRequest.getCaretaker()
        );
    }
}
