package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StayRequest {
    private Integer id;

    private String checkIn;

    private String checkOut;

    private Integer bed_id;

    private Integer guest_id;

    private String invoice_id;
}
