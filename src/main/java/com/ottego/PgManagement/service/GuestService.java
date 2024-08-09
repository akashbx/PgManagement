package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.PaymentDto;
import com.ottego.PgManagement.Dto.RoomDto;
import com.ottego.PgManagement.Request.RoomRequest;
import com.ottego.PgManagement.model.*;
import com.ottego.PgManagement.model.Enum.BedStatus;
import com.ottego.PgManagement.model.Enum.RoomType;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.GuestRepository;
import com.ottego.PgManagement.repository.PgRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private PgRepository pgRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BedRepository bedRepository;

    public String addGuest(String id, String email, String bedName, String name, String phone, String dob, String password, String address, String state, String zip, String city) {
        Guest guest = new Guest();
        guest.setId(Integer.valueOf(id));
        guest.setName(name);
        guest.setEmail(email);
        guest.setPhone(phone);
        guest.setPassword(password);
        guest.setDob(dob);
        guest.setAddress(address);
        guest.setCity(city);
        guest.setState(state);
        guest.setZip(zip);

        guestRepository.save(guest);
        return "Guest added successfully";
    }

    public List<Guest> getGuest() {

        return guestRepository.findAll();
    }

    public String updateGuest(Integer id, String email, String bedName, String name, String phone, String dob, String password, String address, String state, String zip, String city) {
        Guest guest = guestRepository.findById(id).orElse(null);
        if (guest == null) {
            return "Guest not found";
        }

        guest.setName(name);
        guest.setEmail(email);
        guest.setPhone(phone);
        guest.setPassword(password);
        guest.setDob(dob);
        guest.setAddress(address);
        guest.setCity(city);
        guest.setState(state);
        guest.setZip(zip);

        Bed bed = bedRepository.findByName(bedName);
        if (bed != null) {
//            guest.getBeds().clear();
//            guest.getBeds().add(bed);
        } else {
            return "Bed not found";
        }

        guestRepository.save(guest);
        return "Guest updated successfully";
    }


    public Guest getGuestById(Integer guestId) {
        return guestRepository.findById(guestId).orElse(null);
    }
}
