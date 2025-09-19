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
    private StayDto stay;
    private MealDto meal;
    private Diner.DinerStatus status;

    public static DinerDto from(Diner diner) {
        DinerDto dinerDto = new DinerDto();
        dinerDto.setId(diner.getId());
        dinerDto.setItem(diner.getItem());
        dinerDto.setPrice(diner.getPrice());
        dinerDto.setStay(StayDto.from(diner.getStay()));
        dinerDto.setMeal(MealDto.from(diner.getMeal()));
        dinerDto.setStatus(diner.getStatus());
        return dinerDto;
    }
}
