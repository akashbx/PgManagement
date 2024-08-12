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
public class BedDetail {
    private Integer id;
    private String name;
    private BedStatus status;
    private String price;
    private List<StayDto> stays;


    public static BedDetail from(Bed bed) {
        BedDetail bedDetail = new BedDetail();
        bedDetail.setId(bed.getId());
        bedDetail.setName(bed.getName());
        bedDetail.setStatus(bed.getStatus());
        bedDetail.setPrice(bed.getPrice());
        bedDetail.setStays(bed.getStays().stream().map(StayDto::from).toList());
        return bedDetail;
    }
}
