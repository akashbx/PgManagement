package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Dish;
import com.ottego.PgManagement.model.Enum.Cuisine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDetail {
    private Integer id;
    private Cuisine Cuisine;
    private String name;
    private String description;
    private Integer price;
    private PgDto pg;
    private MealDto meals;

    public static DishDetail from(Dish dish) {
        DishDetail dishDetail = new DishDetail();
        dishDetail.setId(dish.getId());
        dishDetail.setCuisine(dish.getCuisine());
        dishDetail.setName(dish.getName());
        dishDetail.setDescription(dish.getDescription());
        dishDetail.setPrice(dish.getPrice());
        dishDetail.setPg(PgDto.from(dish.getPg()));
        dishDetail.setMeals(MealDto.from(dish.getMeals().get(-1)));
        return dishDetail;
    }
}
