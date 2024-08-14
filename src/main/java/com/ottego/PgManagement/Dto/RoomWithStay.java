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
public class RoomWithStay {
    private Integer id;
    private String floor;
    private String roomNumber;
    private String roomType;
    private List<BedWithStay> beds;

    public static RoomWithStay from(Room room) {
        RoomWithStay roomDto = new RoomWithStay();
        roomDto.setId(room.getId());
        roomDto.setFloor(room.getFloor());
        roomDto.setRoomNumber(room.getRoomNumber());
        roomDto.setRoomType(room.getRoomType().toString());
        roomDto.setBeds(room.getBeds().stream().map(BedWithStay::from).toList());
        return roomDto;
    }
}
