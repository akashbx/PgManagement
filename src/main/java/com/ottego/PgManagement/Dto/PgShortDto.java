package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Pg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PgShortDto {
    private Integer id;
    private String name;
    private String phone;
    private String image;

    public static PgShortDto from (Pg pg){
        PgShortDto pgShortDto = new PgShortDto();
        pgShortDto.setId(pg.getId());
        pgShortDto.setName(pg.getName());
        pgShortDto.setPhone(pg.getPhone());
        pgShortDto.setImage(pg.getImage());
        return  pgShortDto;
    }
}
