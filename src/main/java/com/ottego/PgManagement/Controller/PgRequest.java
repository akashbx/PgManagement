package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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
    private List<Room> rooms;

}
