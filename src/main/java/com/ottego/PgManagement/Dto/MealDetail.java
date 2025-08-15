package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Enum.MealType;
import com.ottego.PgManagement.model.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealDetail {
    private Integer id;
    private MealType Type;
    private Integer price;
    private String created_at;
    private String served_at;
    private List<DishDto> dishes;
    private List<DinerDto> diners;
    private PgDto pg;

    public static MealDetail from(Meal meal) {
        MealDetail mealDetail = new MealDetail();
        mealDetail.setId(meal.getId());
        mealDetail.setType(meal.getType());
        mealDetail.setPrice(meal.getPrice());
        mealDetail.setCreated_at(meal.getCreated_at() != null
                ? meal.getCreated_at().toString()
                : null);
        mealDetail.setServed_at(meal.getServed_at());
        mealDetail.setDishes(meal.getDishes().stream().map(DishDto::from).toList());
        mealDetail.setDiners(meal.getDiners().stream().map(DinerDto::from).toList());
        mealDetail.setPg(PgDto.from(meal.getPg()));
        return mealDetail;
    }
}
