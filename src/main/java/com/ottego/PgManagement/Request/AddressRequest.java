package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private Integer id;
    private String hn;
    private String area;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Long latitude;
    private Long longitude;
}
