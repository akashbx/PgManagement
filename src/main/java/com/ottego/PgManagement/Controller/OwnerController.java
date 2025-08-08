package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.OwnerDetail;
import com.ottego.PgManagement.Dto.OwnerDto;
import com.ottego.PgManagement.Request.OwnerRequest;
import com.ottego.PgManagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/{id}")
    public OwnerDetail getOwnerDetails(@PathVariable Integer id) {
       return ownerService.getOwnerDetail(id);
    }

    @GetMapping
    public List<OwnerDto> getOwner() {
        return ownerService.getOwners();
    }
    @PostMapping
    public String addOwner(@RequestBody OwnerRequest owner) {
        ownerService.save(owner);
        return "Owner added successfully";
    }

    @PutMapping
    public String updateOwner(@RequestBody OwnerRequest owner) {
        ownerService.update(owner);
        return "Owner updated successfully";
    }

}
