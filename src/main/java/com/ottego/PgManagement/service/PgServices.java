package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.PgWithRooms;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Room;

import java.util.List;

public interface PgServices {
    String addPg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker, List<Room> rooms, List<Bed> beds);
    String updatePg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker, List<Room> rooms);
    List<PgWithRooms> getAllPgs();
}
