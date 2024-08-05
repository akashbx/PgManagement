package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Bed;
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
public class BedWithGuests {
    private Integer id;
    private String name;
    private BedStatus status;
    private String price;
//    private List<GuestDto> guests;
    private List<StayDto> stays;

    public static BedWithGuests from(Bed bed) {
        BedWithGuests bedWithGuests = new BedWithGuests();
        bedWithGuests.setId(bed.getId());
        bedWithGuests.setName(bed.getName());
        bedWithGuests.setStatus(bed.getStatus());
        bedWithGuests.setPrice(bed.getPrice());
//        bedWithGuests.setGuests(bed.getGuests().stream().map(GuestDto::from).toList());
        bedWithGuests.setStays(bed.getStays().stream().map(StayDto::from).toList());
        return bedWithGuests;
    }
}
