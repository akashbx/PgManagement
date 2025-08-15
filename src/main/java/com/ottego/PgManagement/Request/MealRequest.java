package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealRequest {
    private Integer id;
    private String type;
    private Integer price;
    private String created_at;
    private String served_at;
    private Integer pg_id;
    private List<Integer> dish_ids;
}
