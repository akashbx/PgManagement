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
public class StayWithBedRoom {
    private Integer id;
    private String checkIn;
    private String checkOut;
    private GuestDto guest;
    private BedRoom bed;

    public static StayWithBedRoom from(Stay stay) {
        StayWithBedRoom stayWithBedRoom = new StayWithBedRoom();
        stayWithBedRoom.setId(stay.getId());
        stayWithBedRoom.setCheckIn(stay.getCheckIn());
        stayWithBedRoom.setCheckOut(stay.getCheckOut());
        stayWithBedRoom.setGuest(GuestDto.from(stay.getGuest()));
        stayWithBedRoom.setBed(BedRoom.from(stay.getBed()));
        return stayWithBedRoom;
    }
}
