package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Enum.PgFacility;
import com.ottego.PgManagement.model.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDto {
    private Integer id;
    private PgFacility name;

    public static FacilityDto from(Facility facility) {
        FacilityDto facilityDto = new FacilityDto();
        facilityDto.setId(facility.getId());
        facilityDto.setName(facility.getName());
        return facilityDto;
    }
}
