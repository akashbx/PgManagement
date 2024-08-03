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
public class PgDto {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String caretaker;


    public static PgDto from(Pg pg) {
        PgDto pgDto = new PgDto();
        pgDto.setId(pg.getId());
        pgDto.setName(pg.getName());
        pgDto.setAddress(pg.getAddress());
        pgDto.setCity(pg.getCity());
        pgDto.setState(pg.getState());
        pgDto.setZip(pg.getZip());
        pgDto.setPhone(pg.getPhone());
        pgDto.setCaretaker(pg.getCaretaker());
        return pgDto;
    }

}
