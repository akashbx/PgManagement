package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Enum.MealType;
import com.ottego.PgManagement.model.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {
    private Integer id;
    private MealType Type;
    private String created_at;
    private String served_at;
    private List<DishDto> dishes;
    public static MealDto from(Meal meal) {
        MealDto mealD = new MealDto();
        mealD.setId(meal.getId());
        mealD.setType(meal.getType());
        mealD.setCreated_at(meal.getCreated_at());
        mealD.setServed_at(meal.getServed_at());
        mealD.setDishes(meal.getDishes().stream().map(DishDto::from).toList());
        return mealD;
    }
}
