package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Stay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StayDto {
    private Integer id;
    private String checkIn;
    private String checkOut;
    private GuestDto guest;


    public static StayDto from(Stay stay) {
        StayDto stayDto = new StayDto();
        stayDto.setId(stay.getId());
        stayDto.setCheckIn(stay.getCheckIn());
        stayDto.setCheckOut(stay.getCheckOut());
        stayDto.setGuest(GuestDto.from(stay.getGuest()));
        return stayDto;
    }
}
