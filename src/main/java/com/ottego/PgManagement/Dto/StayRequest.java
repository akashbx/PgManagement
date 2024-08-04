package com.ottego.PgManagement.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StayRequest {
    private String checkIn;
    private String checkOut;

    private Integer bed_id;

    private Integer guest_id;
}
