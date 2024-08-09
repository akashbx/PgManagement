package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Integer id;
    private String floor;
    private String roomNumber;
    private String roomType;

    public static RoomDto from(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setFloor(room.getFloor());
        roomDto.setRoomNumber(room.getRoomNumber());
        roomDto.setRoomType(room.getRoomType().toString());
        return roomDto;
    }
}
