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
public class RoomDetailsShortDto {
    private Integer id;
    private String roomNumber;
    private PgShortDto pg;

    public static RoomDetailsShortDto from (Room room){
        RoomDetailsShortDto roomDetailsShortDto = new RoomDetailsShortDto();
        roomDetailsShortDto.setId(room.getId());
        roomDetailsShortDto.setRoomNumber(room.getRoomNumber());
        roomDetailsShortDto.setPg(PgShortDto.from(room.getPg()));
        return roomDetailsShortDto;
    }
}
