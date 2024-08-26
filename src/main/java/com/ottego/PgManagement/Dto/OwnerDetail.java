package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDetail {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private List<PgDto> pgs;
    private List<GuestDto> guests;

    public static OwnerDetail from(Owner owner) {
        OwnerDetail ownerDetail = new OwnerDetail();
        ownerDetail.setId(owner.getId());
        ownerDetail.setName(owner.getName());
        ownerDetail.setEmail(owner.getEmail());
        ownerDetail.setPhone(owner.getPhone());
        ownerDetail.setPgs(owner.getPgs().stream().map(PgDto::from).toList());
        ownerDetail.setGuests(owner.getGuests().stream().map(GuestDto::from).toList());
        return ownerDetail;
    }
}
