package com.ottego.PgManagement.service;

import com.ottego.PgManagement.model.*;
import com.ottego.PgManagement.model.Enum.BedStatus;
import com.ottego.PgManagement.model.Enum.RoomType;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.GuestRepository;
import com.ottego.PgManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

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
//        guest.setBeds(new ArrayList<>()); // Initialize the beds set

//        Bed bed = bedRepository.findByName(bedName);
//        if (bed != null) {
//            guest.getBeds().add(bed);
//        } else {
//            return "Bed not found";
//        }

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

    public Room addRoom(Integer id, String floor, String roomNumber, String roomType) {
        Room room = new Room();
        room.setId(id);
        room.setFloor(floor);
        room.setRoomNumber(roomNumber);
        room.setRoomType(RoomType.valueOf(roomType));

        return roomRepository.save(room);
    }

    public Guest getGuestById(Integer guestId) {
        return guestRepository.findById(guestId).orElse(null);
    }

    public String updateRoom(Integer roomId, String floor, String roomNumber, String roomType) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room == null) {
            return "Room not found";
        }

        room.setFloor(floor);
        room.setRoomNumber(roomNumber);
        room.setRoomType(RoomType.valueOf(roomType));

        roomRepository.save(room);
        return "Room updated successfully";
    }

    public Room getRoomById(Integer roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }
    public String addBed(String id, String name, String status, String price, Integer roomId) {
        Bed bed = new Bed();
        bed.setId(Integer.valueOf(id));
        bed.setName(name);
        bed.setStatus(BedStatus.valueOf(status));
        bed.setPrice(price);

        // Fetch and set the room for the bed
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));
        bed.setRoom(room);

        bedRepository.save(bed);
        return "Bed added successfully!";
    }

    public String updateBed(String bedId, String name, String s, String status, Integer price) {
        Bed bed = bedRepository.findById(Integer.valueOf(bedId)).orElse(null);
        if (bed == null) {
            return "Bed not found";
        }

        bed.setName(name);
        bed.setStatus(BedStatus.valueOf(status));
        bed.setPrice(String.valueOf(price));

        bedRepository.save(bed);
        return "Bed updated successfully";
    }

    public Bed getBedById(Integer bedId) {
        return bedRepository.findById(bedId).orElse(null);
    }
}
