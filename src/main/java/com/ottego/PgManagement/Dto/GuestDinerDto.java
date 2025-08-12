package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Guest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestDinerDto {
    private String name;
    private String phone;
    private String city;
}
