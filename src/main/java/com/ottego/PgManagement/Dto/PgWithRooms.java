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
    private AddressDto address;
    private String phone;
    private String image;
    private String caretaker;
    private List<FacilityDto> facilities;
    private List<RoomWithBeds> rooms;
    private List<MealDetail> meals;


    public static PgWithRooms from(Pg pg) {
        PgWithRooms pgDto = new PgWithRooms();
        pgDto.setId(pg.getId());
        pgDto.setName(pg.getName());
        pgDto.setPhone(pg.getPhone());
        if (pg.getAddress() != null) {
            pgDto.setAddress(AddressDto.from(pg.getAddress()));
        }
        pgDto.setImage(pg.getImage());
        pgDto.setCaretaker(pg.getCaretaker());
        pgDto.setFacilities(pg.getFacility().stream().map(FacilityDto::from).toList());
        pgDto.setRooms(pg.getRooms().stream().map(RoomWithBeds::from).toList());
        pgDto.setMeals(pg.getMeals().stream().map(MealDetail::from).toList());
        return pgDto;
    }
}
