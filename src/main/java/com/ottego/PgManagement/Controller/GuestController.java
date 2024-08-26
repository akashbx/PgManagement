package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.GuestDto;
import com.ottego.PgManagement.Dto.GuestWithStays;
import com.ottego.PgManagement.Request.GuestRequest;
import com.ottego.PgManagement.model.*;
import com.ottego.PgManagement.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @PostMapping
    public String addGuest(@RequestBody GuestRequest guest) {
        guestService.addGuest(guest);
        return "Guest added successfully";
    }

    @GetMapping
    public List<GuestDto> getGuest(@RequestParam (required = false) Integer owner_id) {
        return guestService.getGuest(owner_id);
    }

    @PutMapping
    public String updateGuest(@RequestBody GuestRequest guest) {
        guestService.updateGuest(guest);
        return "Guest updated successfully";
    }

    @GetMapping("/{id}")
    public GuestWithStays getGuestById(@PathVariable("id") Integer guestId) {
        return guestService.getGuestWithStays(guestId);
    }
    @GetMapping("/search")
    public List<GuestDto> searchGuest(@RequestParam(required = false) String name) {
        return guestService.findGuest(name);
    }

}
