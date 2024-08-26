package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    private Integer id;
    private String name;
    private String email;
    private String phone;

    public static OwnerDto from(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(owner.getId());
        ownerDto.setName(owner.getName());
        ownerDto.setEmail(owner.getEmail());
        ownerDto.setPhone(owner.getPhone());
        return ownerDto;
    }
}
