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
    private List<DishDto> dishes;
    private List<DinerDto> diners;

    public static MealDto from(Meal meal) {
        MealDto mealDto = new MealDto();
        mealDto.setId(meal.getId());
        mealDto.setType(meal.getType());
        mealDto.setDiners(meal.getDiners().stream().map(DinerDto::from).toList());
        mealDto.setDishes(meal.getDishes().stream().map(DishDto::from).toList());
        return mealDto;
    }
}
