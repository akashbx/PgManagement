package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.BedStatus;
import com.ottego.PgManagement.model.Guest;
import com.ottego.PgManagement.model.Room;
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
    public List<Guest> getGuest(@RequestParam String name,
                               @RequestParam(required = false) String bedName) {
        return guestService.getGuest(name, bedName);
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

    @PutMapping("/room")
    public String updateRoom(@RequestParam String roomId,
                             @RequestParam String floor,
                             @RequestParam String roomNumber,
                             @RequestParam String roomType) {
        return guestService.updateRoom(Integer.valueOf(roomId), floor, roomNumber, roomType);
    }

    @GetMapping("/room/{id}")
    public Room getRoomById(@PathVariable("id") Integer roomId) {
        return guestService.getRoomById(roomId);
    }

    @PostMapping("/addbed")
    public String addBed(@RequestBody BedRequest bedRequest) {
        return guestService.addBed(
                bedRequest.getId(),
                bedRequest.getName(),
                bedRequest.getStatus(),
                bedRequest.getPrice(),
                bedRequest.getRoomId()
        );
    }

    @PutMapping("/bed")
    public String updateBed(@RequestParam String bedId,
                            @RequestParam String name,
                            @RequestParam String roomId,
                            @RequestParam BedStatus status,
                            @RequestParam String price) {
        return guestService.updateBed(Integer.valueOf(bedId),roomId, name, status, price);
    }

    @GetMapping("/bed/{id}")
    public Bed getBedById(@PathVariable("id") Integer bedId) {
        return guestService.getBedById(bedId);
    }
}
