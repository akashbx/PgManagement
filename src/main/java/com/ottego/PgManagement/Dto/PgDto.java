package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Pg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PgDto {
    private Integer id;
    private String name;
    private AddressDto address;
    private String phone;
    private String image;
    private String caretaker;


    public static PgDto from(Pg pg) {
        PgDto pgDto = new PgDto();
        pgDto.setId(pg.getId());
        pgDto.setName(pg.getName());
        if (pg.getAddress() != null) {
            pgDto.setAddress(AddressDto.from(pg.getAddress()));
        }
        pgDto.setPhone(pg.getPhone());
        pgDto.setImage(pg.getImage());
        pgDto.setCaretaker(pg.getCaretaker());
        return pgDto;
    }
}
