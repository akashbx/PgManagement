package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Room;
import com.ottego.PgManagement.model.Enum.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomWithBeds {
    private Integer id;
    private String floor;
    private String roomNumber;
    private RoomType roomType;
    private List<BedWithGuests> beds;


    public static RoomWithBeds from(Room room) {
        RoomWithBeds roomWithBeds = new RoomWithBeds();
        roomWithBeds.setId(room.getId());
        roomWithBeds.setFloor(room.getFloor());
        roomWithBeds.setRoomNumber(room.getRoomNumber());
        roomWithBeds.setRoomType(room.getRoomType());
        roomWithBeds.setBeds(room.getBeds().stream().map(BedWithGuests::from).toList());
        return roomWithBeds;
    }
}
