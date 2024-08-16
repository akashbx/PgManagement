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
public class MealDetail {
    private Integer id;
    private MealType Type;
    private List<DishDto> dishes;
    private List<DinerDto> diners;

    public static MealDetail from(Meal meal) {
        MealDetail mealDetail = new MealDetail();
        mealDetail.setId(meal.getId());
        mealDetail.setType(meal.getType());
        mealDetail.setDishes(meal.getDishes().stream().map(DishDto::from).toList());
        mealDetail.setDiners(meal.getDiners().stream().map(DinerDto::from).toList());
        return mealDetail;
    }
}
