package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.BedStatus;
import com.ottego.PgManagement.model.Guest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BedDto {
    private Integer id;
    private String name;
    private BedStatus status;
    private String price;
    private List<GuestDto> guests;

    public static BedDto from(Bed bed) {
        BedDto bedDto = new BedDto();
        bedDto.setId(bed.getId());
        bedDto.setName(bed.getName());
        bedDto.setStatus(bed.getStatus());
        bedDto.setPrice(bed.getPrice());
        bedDto.setGuests(bed.getGuests().stream().map(GuestDto::from).toList());
        return bedDto;
    }
}
