package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.*;
import com.ottego.PgManagement.Request.PgRequest;
import com.ottego.PgManagement.model.*;
import com.ottego.PgManagement.repository.AddressRepository;
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
    private AddressRepository  addressRepository;



    public void save (PgRequest model) {
        Pg pg = new Pg();
        pg.setName(model.getName());
        model.getAddress_id();
        Address address = addressRepository.findById(model.getAddress_id()).get();
        pg.setAddress(address);
        pg.setPhone(model.getPhone());
        pg.setCaretaker(model.getCaretaker());
        pgRepository.save(pg);
    }

    public void update(PgRequest request) {
        Pg pg = pgRepository.findById(request.getId()).get();
        pg.setName(request.getName());
        request.getAddress_id();
        Address address = addressRepository.findById(request.getAddress_id()).get();
        pg.setAddress(address);
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
