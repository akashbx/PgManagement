package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private Integer id;
    private String floor;
    private String roomNumber;
    private String roomType;
    private Integer pg_id;
}
