package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishRequest {
    private Integer id;
    private String Cuisine;
    private String name;
    private String description;
    private String price;
    private Integer meal_id;

}
