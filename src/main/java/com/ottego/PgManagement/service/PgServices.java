package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.PgDto;
import com.ottego.PgManagement.Dto.PgWithRooms;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.repository.PgRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PgServices {
    String addPg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker, List<Room> rooms, List<Bed> beds);
    String updatePg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker, List<Room> rooms);
    List<PgWithRooms> getAllPgs();




}
