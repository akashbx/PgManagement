package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Enum.BedStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BedRoom {
    private Integer id;
    private String name;
    private BedStatus status;
    private Integer price;
    private RoomDetails room;

    public static BedRoom from(com.ottego.PgManagement.model.Bed bed) {
        BedRoom bedRoom = new BedRoom();
        bedRoom.setId(bed.getId());
        bedRoom.setName(bed.getName());
        bedRoom.setStatus(bed.getStatus());
        bedRoom.setPrice(bed.getPrice());
        bedRoom.setRoom(RoomDetails.from(bed.getRoom()));
        return bedRoom;
    }
}
