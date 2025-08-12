package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Diner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DinerMealDto {

    private Integer id;
    private BigDecimal item_price;
    private LocalDateTime served_at;
    private String meal_type;
    private GuestDinerDto guest;
    private DishDinerDto dish;

    public static DinerMealDto from(Diner diner) {
        DinerMealDto dto = new DinerMealDto();

        dto.setId(diner.getId());
        dto.setItem_price(diner.getPrice() != null ? BigDecimal.valueOf(diner.getPrice()) : null);

        if (diner.getMeal().getServed_at() != null) {
            dto.setServed_at(LocalDateTime.parse(diner.getMeal().getServed_at().toString()));
        }

        dto.setMeal_type(diner.getMeal().getType().toString());

        if (diner.getStay() != null && diner.getStay().getGuest() != null) {
            dto.setGuest(new GuestDinerDto(
                    diner.getStay().getGuest().getName(),
                    String.valueOf(diner.getStay().getGuest().getPhone()),
                    diner.getStay().getGuest().getCity()
            ));
        }
        return dto;
    }
}
