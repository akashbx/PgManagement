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
public class BedDetails {
    private Integer id;
    private String name;
    private BedStatus status;
    private String price;
    private RoomDto room;
    private StayDto stay;


    public static BedDetails from(Bed bed) {
        BedDetails bedDetails = new BedDetails();
        bedDetails.setId(bed.getId());
        bedDetails.setName(bed.getName());
        bedDetails.setStatus(bed.getStatus());
        bedDetails.setPrice(bed.getPrice());
        bedDetails.setRoom(RoomDto.from(bed.getRoom()));
        if (!bed.getStays().isEmpty()) {
            bedDetails.setStay(StayDto.from(bed.getStays().getFirst()));
        }
        return bedDetails;
    }
}
