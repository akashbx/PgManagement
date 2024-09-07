package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Dish;
import com.ottego.PgManagement.model.Pg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
  private String image;
  private String caretaker;
  public Long noOfRooms = 0L;
  private List<RoomWithStay>  rooms = new ArrayList<>();
  private List<MealDto> meals = new ArrayList<>();
  private List<FacilityDto> Facilities;
  private List<DishDto> dishes = new ArrayList<>();

    public static PgDetails from(Pg pg) {
      PgDetails pgDetail = new PgDetails();
      pgDetail.setId(pg.getId());
      pgDetail.setName(pg.getName());
      if (pg.getAddress() != null) {
          pgDetail.setAddress(AddressDto.from(pg.getAddress()));
      }
      pgDetail.setPhone(pg.getPhone());
      pgDetail.setImage(pg.getImage());
      pgDetail.setCaretaker(pg.getCaretaker());
      pgDetail.setNoOfRooms((long) pg.getRooms().size());
//      pgDetail.setRooms(pg.getRooms().stream().map(RoomWithStay::from).toList());
//      pgDetail.setMeals(pg.getMeals().stream().map(MealDto::from).toList());
      pgDetail.setFacilities(pg.getFacility().stream().map(FacilityDto::from).toList());
      pgDetail.setDishes(pg.getDishes().stream().map(DishDto::from).toList());
      return pgDetail;
    }
}



