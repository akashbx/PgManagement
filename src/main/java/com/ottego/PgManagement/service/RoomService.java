package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.RoomDetails;
import com.ottego.PgManagement.Dto.RoomDto;
import com.ottego.PgManagement.Dto.RoomWithStay;
import com.ottego.PgManagement.Request.RoomRequest;
import com.ottego.PgManagement.model.Enum.RoomType;
import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.PgRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private PgRepository pgRepository;
    public void update(RoomRequest request) {
        Room room = roomRepository.findById(request.getId()).get();
        room.setFloor(request.getFloor());
        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(RoomType.valueOf(request.getRoomType()));
        pgRepository.findById(request.getPg_id()).ifPresent(room::setPg);
        roomRepository.save(room);
    }

    public List<RoomWithStay> getRooms(Integer pg_id) {
        if (pg_id!=null && pg_id != 0) {
            return roomRepository.findAllByPg_Id(pg_id).stream().map(RoomWithStay::from).toList();
        }else {
            return roomRepository.findAll().stream().map(RoomWithStay::from).toList();
        }

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
    public RoomWithStay getRoomById(Integer id) {
        return RoomWithStay.from(roomRepository.findById(id).get());
    }
    public RoomDetails getRoomDetailsById(Integer id) {
        RoomDetails room = RoomDetails.from(roomRepository.findById(id).get());
        room.setNoOfBeds((long) bedRepository.countBedsByRoomId(id));
        return room;

    }
}
