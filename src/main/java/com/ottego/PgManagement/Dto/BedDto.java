package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.BedStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BedDto {
    private Integer id;
    private String name;
    private BedStatus status;
    private String price;
    private RoomDto room;

    public static BedDto from(Bed bed) {
        BedDto bedDto = new BedDto();
        bedDto.setId(bed.getId());
        bedDto.setName(bed.getName());
        bedDto.setStatus(bed.getStatus());
        bedDto.setPrice(bed.getPrice());
        bedDto.setRoom(RoomDto.from(bed.getRoom()));
        return bedDto;
    }
}
