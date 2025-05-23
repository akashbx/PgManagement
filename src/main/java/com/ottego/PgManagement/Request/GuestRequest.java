package com.ottego.PgManagement.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestRequest {
    private Integer id;
    private String email;
    private String name;
    private String phone;
    private String dob;
    private String profession;
    private String password;
    private String address;
    private String state;
    private String zip;
    private String city;
    private Integer owner_id;
}
