package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Enum.MealType;
import com.ottego.PgManagement.model.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {
    private Integer id;
    private MealType Type;
    public static MealDto from(Meal meal) {
        MealDto mealD = new MealDto();
        mealD.setId(meal.getId());
        mealD.setType(meal.getType());
        return mealD;
    }
}
