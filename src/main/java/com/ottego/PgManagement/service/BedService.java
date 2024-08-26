package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.BedDetails;
import com.ottego.PgManagement.Dto.BedWithStay;
import com.ottego.PgManagement.Request.BedRequest;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Enum.BedStatus;
import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {
    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void update(BedRequest request) {
        Bed bed = bedRepository.findById(request.getId()).get();
        bed.setName(request.getName());
        bed.setStatus(BedStatus.valueOf(request.getStatus()));
        bed.setPrice(request.getPrice());
        request.getRoom_id();
        Room room = roomRepository.findById(request.getRoom_id()).get();
        bed.setRoom(room);
        bedRepository.save(bed);
    }
    public void save(BedRequest request) {
        Bed bed = new Bed();
        bed.setName(request.getName());
        bed.setStatus(BedStatus.valueOf(request.getStatus()));
        bed.setPrice(request.getPrice());
        request.getRoom_id();
        Room room = roomRepository.findById(request.getRoom_id()).get();
        bed.setRoom(room);
        bedRepository.save(bed);
    }


    public BedDetails getBedById(Integer Id) {
        return BedDetails.from(bedRepository.findById(Id).get());
    }

    public BedWithStay getBedDetailsById(Integer Id) {
        return BedWithStay.from(bedRepository.findById(Id).get());
    }

    public List<BedDetails> getBeds(Integer room_id) {
        if (room_id != null && room_id != 0) {
            return bedRepository.findBedByRoom_id(room_id).stream().map(BedDetails::from).toList();
        } else {
            return bedRepository.findAll().stream().map(BedDetails::from).toList();
        }
    }
}
