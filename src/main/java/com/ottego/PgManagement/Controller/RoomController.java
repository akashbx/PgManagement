package com.ottego.PgManagement.Controller;



import com.ottego.PgManagement.Dto.RoomDetails;
import com.ottego.PgManagement.Dto.RoomDto;
import com.ottego.PgManagement.Dto.RoomWithStay;
import com.ottego.PgManagement.Request.RoomRequest;
import com.ottego.PgManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomWithStay> getAllRooms(@RequestParam(required = false) Integer pg_id) {
        return roomService.getRooms(pg_id);
    }

    @PostMapping
    public String addRoom(@RequestBody RoomRequest room) {
        roomService.save(room);
        return "Room added successfully";
    }

    @PutMapping
    public String updateRoom(@RequestBody RoomRequest room) {
        roomService.update(room);
        return "Room added successfully";
    }

    @GetMapping("/count/{pgId}")
    public long getRoomCount(@PathVariable Integer pgId) {
        return roomService.countRoomsInPg(pgId);
    }
    @GetMapping("/{id}")
    public RoomWithStay getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }
    @GetMapping("details/{id}")
    public RoomDetails getRoomDetailsById(@PathVariable Integer id) {
        return roomService.getRoomDetailsById(id);
    }
}
