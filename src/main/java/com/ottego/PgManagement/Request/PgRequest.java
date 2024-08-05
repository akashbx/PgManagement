package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PgRequest {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String caretaker;

}
