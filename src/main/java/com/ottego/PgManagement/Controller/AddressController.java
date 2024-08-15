package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.AddressDto;
import com.ottego.PgManagement.Request.AddressRequest;
import com.ottego.PgManagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping
    public String addAddress(@RequestBody AddressRequest address) {
        addressService.save(address);
        return "Address added successfully";
    }
    @PutMapping
    public String updateAddress(@RequestBody AddressRequest address) {
        addressService.update(address);
        return "Address added successfully";
    }

    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable Integer id) {
        return addressService.getById(id);
    }
}
