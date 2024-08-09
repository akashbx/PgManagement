package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Request.BedRequest;
import com.ottego.PgManagement.Request.GuestRequest;
import com.ottego.PgManagement.model.*;
import com.ottego.PgManagement.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @PostMapping("/newguest")
    public String addGuest(@RequestBody GuestRequest guestRequest) {
        return guestService.addGuest(
                guestRequest.getId(),
                guestRequest.getEmail(),
                guestRequest.getBedName(),
                guestRequest.getName(),
                guestRequest.getPhone(),
                guestRequest.getDob(),
                guestRequest.getPassword(),
                guestRequest.getAddress(),
                guestRequest.getState(),
                guestRequest.getZip(),
                guestRequest.getCity()
        );
    }

    @GetMapping("/guest")
    public List<Guest> getGuest() {
        return guestService.getGuest();
    }

    @PutMapping("/updateguest")
    public String updateGuest(@RequestBody GuestRequest guestRequest) {
        return guestService.updateGuest(
                Integer.valueOf(guestRequest.getId()),
                guestRequest.getEmail(),
                guestRequest.getBedName(),
                guestRequest.getName(),
                guestRequest.getPhone(),
                guestRequest.getDob(),
                guestRequest.getPassword(),
                guestRequest.getAddress(),
                guestRequest.getState(),
                guestRequest.getZip(),
                guestRequest.getCity()
        );
    }

    @GetMapping("/guest/{id}")
    public Guest getGuestById(@PathVariable("id") Integer guestId) {
        return guestService.getGuestById(guestId);
    }

}
