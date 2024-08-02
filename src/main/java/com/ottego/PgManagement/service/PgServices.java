package com.ottego.PgManagement.service;

import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.repository.PgRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PgServices implements PgServiceImpl {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PgRepository pgRepository;

    public String addPg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker) {
        Pg pg = new Pg();
        pg.setId(id);
        pg.setName(name);
        pg.setAddress(address);
        pg.setCity(city);
        pg.setState(state);
        pg.setZip(zip);
        pg.setPhone(phone);
        pg.setCaretaker(caretaker);
        pgRepository.save(pg);
        return "Pg added successfully";
    }

    @Override
    public String updatePg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker) {
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
        pgRepository.save(pg);
        return "Pg updated successfully";
    }

    @Override
    public List<Pg> getAllPgs() {
        return pgRepository.findAll();
    }

    public Pg getPgDetails(Integer id) {

        return pgRepository.findById(id).get();
    }
}
