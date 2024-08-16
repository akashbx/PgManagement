package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.AddressDetail;
import com.ottego.PgManagement.Request.AddressRequest;
import com.ottego.PgManagement.model.Address;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.repository.AddressRepository;
import com.ottego.PgManagement.repository.PgRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        address.setLatitude(model.getLatitude());
        address.setLongitude(model.getLongitude());
        Pg pg = pgRepository.findById(model.getId()).get();
        address.setPg(pg);
        addressRepository.save(address);
    }

    public void update(AddressRequest request) {
        Optional<Address> optionalAddress = addressRepository.findById(request.getId());
        Address address = optionalAddress.orElseGet(Address::new);
        address.setHn(request.getHn());
        address.setArea(request.getArea());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZip(request.getZip());
        address.setLatitude(request.getLatitude());
        address.setLongitude(request.getLongitude());
        Pg pg = pgRepository.findById(request.getId()).get();
        address.setPg(pg);
        addressRepository.save(address);
    }

    public List<AddressDetail> getAll() {
        return addressRepository.findAll().stream().map(AddressDetail::from).toList();
    }

    public AddressDetail getById(Integer id) {
        return AddressDetail.from(addressRepository.findById(id).get());
    }

    public AddressDetail getDetails(Integer id) {
        return AddressDetail.from(addressRepository.findById(id).get());
    }

    public List<AddressDetail> getAll(String search, String city, String state, String zip) {

        return addressRepository.findAll(AddressSpecification.hasFieldsLike(search,city,state,zip)).stream().map(AddressDetail::from).toList();
    }

    private static final ExampleMatcher SEARCH_CONDITIONS_MATCH_ANY = ExampleMatcher
            .matchingAny()
            .withMatcher("state", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("city", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("zip", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("area", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("street", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withIgnorePaths("id", "pg.id", "hn", "latitude", "longitude");

    private static final ExampleMatcher SEARCH_CONDITIONS_MATCH_ALL = ExampleMatcher
            .matchingAll()
            .withMatcher("state", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("city", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("zip", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("area", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("street", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withIgnorePaths("id", "pg.id", "hn", "latitude", "longitude");

    @Transactional(readOnly = true)
    public List<Address> list(String state, String city, String area, String zip, String street, boolean matchAll, int page, int pageSize, String sortField, Sort.Direction sortDirection) {
        Pageable pageable = pageable(page, pageSize, sortField, sortDirection);

        Address address = Address.builder()
                .state(state)
                .city(city)
                .area(area)
                .zip(zip)
                .street(street)
                .build();

        Example<Address> example = Example.of(address, matchAll ? SEARCH_CONDITIONS_MATCH_ALL : SEARCH_CONDITIONS_MATCH_ANY);
        Page<Address> addresses = addressRepository.findAll(example, pageable);
        return addresses.toList();
    }

    private Pageable pageable(int page, int pageSize, String sortField, Sort.Direction sortDirection) {
        if (sortField == null || sortField.isEmpty()) {
            return PageRequest.of(page, pageSize);
        } else {
            return PageRequest.of(page, pageSize, sortDirection, sortField);
        }
    }



}

class AddressSpecification {
    public static Specification<Address> hasCity(String city) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("city"), city);
    }

    public static Specification<Address> hasState(String state) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("state"), state);
    }

    public static Specification<Address> hasZip(String zip) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("zip"), zip);
    }

    public static Specification<Address> hasCityLike(String search) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("city"), "%" + search + "%");
    }

    public static Specification<Address> hasStateLike(String search) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("state"), "%" + search + "%");
    }

    public static Specification<Address> hasStreetLike(String search) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("street"), "%" + search + "%");
    }

    public static Specification<Address> hasFieldsLike(String search,String city, String state, String zip) {
       return Specification.where(hasCityLike(search))
                .or(hasStateLike(search))
                .or(hasStreetLike(search))
               .or(hasCity(city))
               .or(hasState(state))
               .or(hasZip(zip));
    }
}
