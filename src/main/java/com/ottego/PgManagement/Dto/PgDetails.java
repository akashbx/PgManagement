package com.ottego.PgManagement.model;

import com.ottego.PgManagement.Dto.FacilityDto;
import com.ottego.PgManagement.Dto.MealDetail;
import com.ottego.PgManagement.Dto.MealDto;
import com.ottego.PgManagement.Dto.RoomDto;
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
  private String address;
  private String city;
  private String state;
  private String zip;
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
      pgDetail.setAddress(pg.getAddress());
      pgDetail.setCity(pg.getCity());
      pgDetail.setState(pg.getState());
      pgDetail.setZip(pg.getZip());
      pgDetail.setPhone(pg.getPhone());
      pgDetail.setCaretaker(pg.getCaretaker());
      pgDetail.setNoOfRooms((long) pg.getRooms().size());
      pgDetail.setRooms(pg.getRooms().stream().map(RoomDto::from).toList());
      pgDetail.setMeals(pg.getMeals().stream().map(MealDto::from).toList());
      pgDetail.setFacilities(pg.getFacility().stream().map(FacilityDto::from).toList());
      return pgDetail;
    }
}



