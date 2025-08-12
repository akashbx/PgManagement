package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDinerDto {
    private String name;
    private Integer id;

    public static DishDinerDto from(Dish dish) {
        DishDinerDto dishDinerDto = new DishDinerDto();
        dishDinerDto.setName(dish.getName());
        dishDinerDto.setId(dish.getId());
        return dishDinerDto;
    }
}
