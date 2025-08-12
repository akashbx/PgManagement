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
public class GuestShortDto {
    private Integer id;
    private String name;
    private String email;
    private String phone;

    public static GuestShortDto from(Guest guest) {
        GuestShortDto guestShortDto = new GuestShortDto();
        guestShortDto.setId(guest.getId());
        guestShortDto.setName(guest.getName());
        guestShortDto.setEmail(guest.getEmail());
        guestShortDto.setPhone(String.valueOf(guest.getPhone()));
        return guestShortDto;
    }
}
