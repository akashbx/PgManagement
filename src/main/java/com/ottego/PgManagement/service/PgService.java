package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.PgDto;
import com.ottego.PgManagement.Dto.PgWithRooms;
import com.ottego.PgManagement.Dto.PgsResponse;
import com.ottego.PgManagement.Dto.RoomDto;
import com.ottego.PgManagement.Request.PgRequest;
import com.ottego.PgManagement.model.Meal;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.model.PgDetails;
import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.PgRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PgService  {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PgRepository pgRepository;

    @Autowired
    private BedRepository bedRepository;



    public void save (PgRequest model) {
        Pg pg = new Pg();
        pg.setName(model.getName());
        pg.setAddress(model.getAddress());
        pg.setCity(model.getCity());
        pg.setState(model.getState());
        pg.setZip(model.getZip());
        pg.setPhone(model.getPhone());
        pg.setCaretaker(model.getCaretaker());
        pgRepository.save(pg);
    }

    public void update(PgRequest request) {
        Pg pg = pgRepository.findById(request.getId()).get();
        pg.setName(request.getName());
        pg.setAddress(request.getAddress());
        pg.setCity(request.getCity());
        pg.setState(request.getState());
        pg.setZip(request.getZip());
        pg.setPhone(request.getPhone());
        pg.setCaretaker(request.getCaretaker());
        pgRepository.save(pg);

    }


    public List<PgDto> getAllPgs() {
        PgsResponse pgsResponse = new PgsResponse();
        pgsResponse.data = pgRepository.findAll().stream().map(PgDto::from).toList();
        return pgsResponse.data;
    }

    public List<PgWithRooms> getAllPgsWithRooms() {
        return pgRepository.findAll().stream().map(PgWithRooms::from).toList();
    }

    public PgDetails getPgDetails(Integer id) {

        PgDetails pg = pgRepository.findById(id).map(PgDetails::from).get();
        pg.noOfRooms = roomRepository.countRoomsByPgId(id);
        return pg;
    }
}
