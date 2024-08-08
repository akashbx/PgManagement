package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.PgDto;
import com.ottego.PgManagement.Dto.PgWithRooms;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Meal;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.PgRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PgServiceImpl implements PgServices {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PgRepository pgRepository;
    @Autowired
    private BedRepository bedRepository;

    public String addPg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker, List<Room> rooms, List<Meal> meal) {
        Pg pg = new Pg();
        pg.setId(id);
        pg.setName(name);
        pg.setAddress(address);
        pg.setCity(city);
        pg.setState(state);
        pg.setZip(zip);
        pg.setPhone(phone);
        pg.setCaretaker(caretaker);
        pg.getRooms();
        pg.getMeals();
        pgRepository.save(pg);
        return "Pg added successfully";
    }

    public String updatePg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker, List<Room> rooms, List<Meal> meal) {
        Pg pg = pgRepository.findById(Math.toIntExact(id)).orElse(null);
        if (pg == null) {
            return "Pg not found";
        }
        pg.setName(name);
        pg.setAddress(address);
        pg.setCity(city);
        pg.setState(state);
        pg.setZip(zip);
        pg.setPhone(phone);
        pg.setCaretaker(caretaker);
        pg.getRooms();
        pg.getMeals();
        pgRepository.save(pg);
        return "Pg updated successfully";
    }

    @Override
    public List<PgDto> getAllPgs() {
        return pgRepository.findAll().stream().map(PgDto::from).toList();
    }

    @Override
    public List<PgWithRooms> getAllPgsWithRooms() {
        return pgRepository.findAll().stream().map(PgWithRooms::from).toList();
    }

    public Pg getPgDetails(Integer id) {

        return pgRepository.findById(id).get();
    }
}
