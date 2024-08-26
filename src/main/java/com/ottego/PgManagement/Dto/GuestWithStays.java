package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Guest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestWithStays {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String dob;
    private String profession;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private List<StayDto> stays;

    public static GuestWithStays from(Guest guest) {
        GuestWithStays guestWithStays = new GuestWithStays();
        guestWithStays.setId(guest.getId());
        guestWithStays.setName(guest.getName());
        guestWithStays.setEmail(guest.getEmail());
        guestWithStays.setPassword(guest.getPassword());
        guestWithStays.setDob(guest.getDob());
        guestWithStays.setProfession(guest.getProfession());
        guestWithStays.setPhone(guest.getPhone());
        guestWithStays.setAddress(guest.getAddress());
        guestWithStays.setCity(guest.getCity());
        guestWithStays.setState(guest.getState());
        guestWithStays.setZip(guest.getZip());
        guestWithStays.setStays(guest.getStays().stream().map(StayDto::from).toList());
        return guestWithStays;
    }
}
