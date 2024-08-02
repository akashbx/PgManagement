package com.ottego.PgManagement.service;

import com.ottego.PgManagement.model.Pg;

import java.util.List;

public interface PgServiceImpl {
    String addPg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker);
    String updatePg(Integer id, String name, String address, String city, String state, String zip, String phone, String caretaker);
    List<Pg> getAllPgs();
}
