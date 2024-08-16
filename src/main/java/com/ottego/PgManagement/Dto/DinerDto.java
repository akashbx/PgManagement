package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Diner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DinerDto {
    private Integer id;
    private String item;
    private Integer price;

    public static DinerDto from(Diner diner) {
        DinerDto dinerDto = new DinerDto();
        dinerDto.setId(diner.getId());
        dinerDto.setItem(diner.getItem());
        dinerDto.setPrice(diner.getPrice());
        return dinerDto;
    }
}
