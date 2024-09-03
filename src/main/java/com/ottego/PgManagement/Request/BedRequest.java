package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BedRequest {
    private Integer id;
    private String name;
    private String status;
    private Integer price;
    private Integer room_id;
}
