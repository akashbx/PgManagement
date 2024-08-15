package com.ottego.PgManagement.Request;

import com.ottego.PgManagement.model.Address;
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
    private String phone;
    private Address address;
    private String image;
    private String caretaker;

}
