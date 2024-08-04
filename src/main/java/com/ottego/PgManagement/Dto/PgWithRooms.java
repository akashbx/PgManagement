package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Pg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PgWithRooms {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String caretaker;
    private List<RoomWithBeds> rooms;


    public static PgWithRooms from(Pg pg) {
        PgWithRooms pgDto = new PgWithRooms();
        pgDto.setId(pg.getId());
        pgDto.setName(pg.getName());
        pgDto.setAddress(pg.getAddress());
        pgDto.setCity(pg.getCity());
        pgDto.setState(pg.getState());
        pgDto.setZip(pg.getZip());
        pgDto.setPhone(pg.getPhone());
        pgDto.setCaretaker(pg.getCaretaker());
        pgDto.setRooms(pg.getRooms().stream().map(RoomWithBeds::from).toList());
        return pgDto;
    }
}
