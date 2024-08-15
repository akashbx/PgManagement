package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.AddressDto;
import com.ottego.PgManagement.Request.AddressRequest;
import com.ottego.PgManagement.model.Address;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.repository.AddressRepository;
import com.ottego.PgManagement.repository.PgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PgRepository pgRepository;

    public void save(AddressRequest model) {
        Address address = new Address();
        address.setHn(model.getHn());
        address.setArea(model.getArea());
        address.setStreet(model.getStreet());
        address.setCity(model.getCity());
        address.setState(model.getState());
        address.setZip(model.getZip());
        model.getPg_id();
        Pg pg = pgRepository.findById(model.getPg_id()).get();
        address.setPg(pg);
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
        request.getPg_id();
        Pg pg = pgRepository.findById(request.getPg_id()).get();
        address.setPg(pg);
        addressRepository.save(address);
    }

    public List<AddressDto> getAll(){
        return addressRepository.findAll().stream().map(AddressDto::from).toList();
    }

    public AddressDto getById(Integer id) {
        return AddressDto.from(addressRepository.findById(id).get());
    }
}
