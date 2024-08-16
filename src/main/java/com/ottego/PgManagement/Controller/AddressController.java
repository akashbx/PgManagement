package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.AddressDetail;
import com.ottego.PgManagement.Request.AddressRequest;
import com.ottego.PgManagement.model.Address;
import com.ottego.PgManagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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
    public List<AddressDetail> getAllAddresses() {
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    public AddressDetail getAddressById(@PathVariable Integer id) {
        return addressService.getById(id);
    }
    @GetMapping("/detail/{id}")
    public AddressDetail getAddressDetailById(@PathVariable Integer id) {
        return addressService.getDetails(id);
    }

    @GetMapping("/search")
    public ResponseEntity <List<AddressDetail>> getAddress(@RequestParam (value = "search",required = false) String search,
                                                           @RequestParam(value = "city",required = false) String city,
                                                           @RequestParam(value = "state",required = false) String state,
                                                           @RequestParam(value = "zip",required = false) String zip) {
        List<AddressDetail> addressDetails = addressService.getAll(search, city, state,zip);
        if (!addressDetails.isEmpty()) {
            return ResponseEntity.ok(addressDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("ok")
    public ResponseEntity<List<Address>> getAddressDetails(
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String area,
            @RequestParam(required = false) String zip,
            @RequestParam(required = false) String street,
            @RequestParam(defaultValue = "false") boolean matchAll,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection
    ) {
        List<Address> addresses = addressService.list(state, city, area, zip, street, matchAll, page, pageSize, sortField, sortDirection);
        return ResponseEntity.ok(addresses);
    }
}
