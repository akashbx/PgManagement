package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.RoomDto;
import com.ottego.PgManagement.Request.RoomRequest;
import com.ottego.PgManagement.model.Enum.RoomType;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.repository.PgRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired

    private PgRepository pgRepository;
    public void update(RoomRequest request) {
        Room room = roomRepository.findById(request.getId()).get();
        room.setFloor(request.getFloor());
        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(RoomType.valueOf(request.getRoomType()));
        room.setPg(pgRepository.findById(request.getPg_id()).get());
        roomRepository.save(room);
    }

    public List<RoomDto> getRooms() {
        return roomRepository.findAll().stream().map(RoomDto::from).toList();
    }

    public void save(RoomRequest request) {
        Room room = new Room();
        room.setFloor(request.getFloor());
        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(RoomType.valueOf(request.getRoomType()));
        pgRepository.findById(request.getPg_id()).ifPresent(room::setPg);
        roomRepository.save(room);
    }
    public long countRoomsInPg(Integer pgId) {
        return roomRepository.countRoomsByPgId(pgId);
    }
}
