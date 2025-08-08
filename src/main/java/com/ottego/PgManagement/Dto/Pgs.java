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
public class Pgs {
    private Integer id;
    private String name;
    private String phone;
    private String image;


    public static Pgs from(Pg pg) {
        Pgs pgsDto = new Pgs();
        pgsDto.setId(pg.getId());
        pgsDto.setName(pg.getName());
        pgsDto.setPhone(pg.getPhone());
        pgsDto.setImage(pg.getImage());

        return pgsDto;
    }
}
