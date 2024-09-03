package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StayRequest {
    private Integer id;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Integer bed_id;

    private Integer guest_id;

    private String invoice_id;
}
