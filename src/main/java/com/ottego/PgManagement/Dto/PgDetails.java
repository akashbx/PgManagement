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
public  class PgDetails{
  private Integer id;
  private String name;
  private AddressDto address;
  private String phone;
  private String caretaker;
  public Long noOfRooms = 0L;
  private List<RoomDto>  rooms;
  private List<MealDto> meals;
  private List<FacilityDto> Facilities;

    public static PgDetails from(Pg pg) {
      PgDetails pgDetail = new PgDetails();
      pgDetail.setId(pg.getId());
      pgDetail.setName(pg.getName());
      pgDetail.setAddress(AddressDto.from(pg.getAddress()));
      pgDetail.setPhone(pg.getPhone());
      pgDetail.setCaretaker(pg.getCaretaker());
      pgDetail.setNoOfRooms((long) pg.getRooms().size());
      pgDetail.setRooms(pg.getRooms().stream().map(RoomDto::from).toList());
      pgDetail.setMeals(pg.getMeals().stream().map(MealDto::from).toList());
      pgDetail.setFacilities(pg.getFacility().stream().map(FacilityDto::from).toList());
      return pgDetail;
    }
}



