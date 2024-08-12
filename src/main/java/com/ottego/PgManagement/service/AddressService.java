package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.AddressDto;
import com.ottego.PgManagement.Request.AddressRequest;
import com.ottego.PgManagement.model.Address;
import com.ottego.PgManagement.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void save(AddressRequest model) {
        Address address = new Address();
        address.setHn(model.getHn());
        address.setArea(model.getArea());
        address.setStreet(model.getStreet());
        address.setCity(model.getCity());
        address.setState(model.getState());
        address.setZip(model.getZip());
        addressRepository.save(address);
    }

    public void update(AddressRequest request) {
        Address address = addressRepository.findById(request.getId()).get();
        address.setHn(request.getHn());
        address.setArea(request.getArea());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZip(request.getZip());
        addressRepository.save(address);
    }

    public List<AddressDto> getAll(){
        return addressRepository.findAll().stream().map(AddressDto::from).toList();
    }
}
