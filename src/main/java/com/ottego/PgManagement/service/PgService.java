package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.*;
import com.ottego.PgManagement.Request.PgRequest;
import com.ottego.PgManagement.model.*;
import com.ottego.PgManagement.repository.*;
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
    private OwnerRepository ownerRepository;

    @Autowired
    private DishRepository dishRepository;



    public void save (PgRequest model) {
        Pg pg = new Pg();
        pg.setName(model.getName());
        pg.setPhone(model.getPhone());
        pg.setAddress(model.getAddress());
        pg.setImage(model.getImage());
        pg.setCaretaker(model.getCaretaker());
        model.getOwner_id();
        Owner owner = ownerRepository.findById(model.getOwner_id()).get();
        pg.setOwner(owner);
        pgRepository.save(pg);
    }

    public void update(PgRequest request) {
        Pg pg = pgRepository.findById(request.getId()).get();
        pg.setName(request.getName());
        pg.setPhone(request.getPhone());
        pg.setAddress(request.getAddress());
        pg.setImage(request.getImage());
        pg.setCaretaker(request.getCaretaker());
        pgRepository.save(pg);

    }


    public List<PgDto> getAllPgs(Integer owner_id) {
        if (owner_id != null && owner_id != 0) {
            return pgRepository.findAllByOwner_id(owner_id).stream().map(PgDto::from).toList();
        }
        else {
            return pgRepository.findAll().stream().map(PgDto::from).toList();
        }
    }

    public List<PgWithRooms> getAllPgsWithRooms() {
        return pgRepository.findAll().stream().map(PgWithRooms::from).toList();
    }

    public PgDetails getPgDetails(Integer id) {

        PgDetails pg = pgRepository.findById(id).map(PgDetails::from).get();
        pg.noOfRooms = roomRepository.countRoomsByPgId(id);
//        pg.setDishes(dishRepository.findAll().stream().map(DishDto::from).toList());
        return pg;
    }
}
