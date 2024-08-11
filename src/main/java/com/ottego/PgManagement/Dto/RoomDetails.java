package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetails {
    private Integer id;
    private String floor;
    private String roomNumber;
    private String roomType;
    private Long noOfBeds;
    private PgDto pg;

    public static RoomDetails from(Room room) {
        RoomDetails roomDetails = new RoomDetails();
        roomDetails.setId(room.getId());
        roomDetails.setFloor(room.getFloor());
        roomDetails.setRoomNumber(room.getRoomNumber());
        roomDetails.setRoomType(room.getRoomType().toString());
        roomDetails.setPg(PgDto.from(room.getPg()));
        roomDetails.setNoOfBeds((long) room.getBeds().size());
        return roomDetails;
    }
}
