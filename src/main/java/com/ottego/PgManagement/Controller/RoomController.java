package com.ottego.PgManagement.Controller;



import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping
    public String addRoom(@RequestBody Room room) {
        roomRepository.save(room);
        return "Room added successfully";
    }
}
