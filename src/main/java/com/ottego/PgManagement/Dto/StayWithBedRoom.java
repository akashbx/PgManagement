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
public class StayWithBedRoom {
    private Integer id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private GuestDto guest;
    private BedRoom beds;

    public static StayWithBedRoom from(Stay stay) {
        StayWithBedRoom stayWithBedRoom = new StayWithBedRoom();
        stayWithBedRoom.setId(stay.getId());
        stayWithBedRoom.setCheckIn(stay.getCheckIn());
        stayWithBedRoom.setCheckOut(stay.getCheckOut());
        stayWithBedRoom.setGuest(GuestDto.from(stay.getGuest()));
        stayWithBedRoom.setBeds(BedRoom.from(stay.getBed()));
        return stayWithBedRoom;
    }
}
