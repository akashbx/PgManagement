package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Guest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String dob;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;

    public static GuestDto from(Guest guest){

        GuestDto guestDto = new GuestDto();

        guestDto.setId(guest.getId());
        guestDto.setName(guest.getName());
        guestDto.setEmail(guest.getEmail());
        guestDto.setPassword(guest.getPassword());
        guestDto.setDob(guest.getDob());
        guestDto.setPhone(guest.getPhone());
        guestDto.setAddress(guest.getAddress());
        guestDto.setCity(guest.getCity());
        guestDto.setState(guest.getState());
        guestDto.setZip(guest.getZip());
        return guestDto;
    }
}
