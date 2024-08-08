package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DinerRequest {
    private Integer id;
    private String item;
    private String price;
    private Integer stayId;
    private Integer mealId;
}
