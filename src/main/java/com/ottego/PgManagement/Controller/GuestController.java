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

    @GetMapping
    public List<GuestDto> getGuest() {
        return guestService.getGuest();
    }

    @PutMapping
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

    @GetMapping("/{id}")
    public GuestWithStays getGuestById(@PathVariable("id") Integer guestId) {
        return guestService.getGuestWithStays(guestId);
    }

}
