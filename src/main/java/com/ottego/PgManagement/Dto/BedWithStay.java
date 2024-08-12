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
public class BedWithStay {
    private Integer id;
    private String name;
    private BedStatus status;
    private String price;
    private List<StayDetails> stays;

    public static BedWithStay from(Bed bed) {
        BedWithStay bedWithStay = new BedWithStay();
        bedWithStay.setId(bed.getId());
        bedWithStay.setName(bed.getName());
        bedWithStay.setStatus(bed.getStatus());
        bedWithStay.setPrice(bed.getPrice());
        bedWithStay.setStays(bed.getStays().stream().map(StayDetails::from).toList());
        return bedWithStay;
    }
}
