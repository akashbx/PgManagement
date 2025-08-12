package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Stay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StayShortDto {
    private Integer id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private GuestShortDto guest;
    private BedRoomShortDto Bed;

    public static StayShortDto from(Stay stay) {
        StayShortDto stayShortDto = new StayShortDto();
        stayShortDto.setId(stay.getId());
        stayShortDto.setCheckIn(stay.getCheckIn());
        stayShortDto.setCheckOut(stay.getCheckOut());
        stayShortDto.setGuest(GuestShortDto.from(stay.getGuest()));
        stayShortDto.setBed(BedRoomShortDto.from(stay.getBed()));
        return stayShortDto;
    }

}
