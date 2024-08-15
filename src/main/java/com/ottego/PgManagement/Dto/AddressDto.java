package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer id;
    private String hn;
    private String area;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Integer pg_id;

    public static AddressDto from(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setHn(address.getHn());
        addressDto.setArea(address.getArea());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setZip(address.getZip());
        addressDto.setPg_id(address.getPg().getId());
        return addressDto;
    }
}
