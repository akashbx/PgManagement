package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Dish;
import com.ottego.PgManagement.model.Enum.Cuisine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private Integer id;
    private Cuisine Cuisine;
    private String name;
    private String description;
    private String price;

    public static DishDto from(Dish dish) {
        DishDto dishDto = new DishDto();
        dishDto.setId(dish.getId());
        dishDto.setCuisine(dish.getCuisine());
        dishDto.setName(dish.getName());
        dishDto.setDescription(dish.getDescription());
        dishDto.setPrice(dish.getPrice());
        return dishDto;
    }
}
