package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Enum.BedStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BedRoomShortDto {
    private Integer id;
    private String name;
    private BedStatus status;
    private RoomDetailsShortDto room;

    public static BedRoomShortDto from(Bed bed) {
        BedRoomShortDto bedRoomShortDto = new BedRoomShortDto();
        bedRoomShortDto.setId(bed.getId());
        bedRoomShortDto.setName(bed.getName());
        bedRoomShortDto.setStatus(bed.getStatus());
        bedRoomShortDto.setRoom(RoomDetailsShortDto.from(bed.getRoom()));
        return bedRoomShortDto;
    }
}
