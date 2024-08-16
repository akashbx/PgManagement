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
public class AddressDetail {
    private Integer id;
    private String hn;
    private String area;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Long latitude;
    private Long longitude;
    private Pgs Pg;

    public static AddressDetail from(Address address) {
        AddressDetail addressDetail = new AddressDetail();
        addressDetail.setId(address.getId());
        addressDetail.setHn(address.getHn());
        addressDetail.setArea(address.getArea());
        addressDetail.setStreet(address.getStreet());
        addressDetail.setCity(address.getCity());
        addressDetail.setState(address.getState());
        addressDetail.setZip(address.getZip());
        addressDetail.setLatitude(address.getLatitude());
        addressDetail.setLongitude(address.getLongitude());
        addressDetail.setPg(Pgs.from(address.getPg()));
        return addressDetail;
    }
}
