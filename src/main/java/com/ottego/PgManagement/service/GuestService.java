package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.GuestDto;
import com.ottego.PgManagement.Dto.GuestWithStays;
import com.ottego.PgManagement.Request.GuestRequest;
import com.ottego.PgManagement.model.*;
import com.ottego.PgManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public void addGuest(GuestRequest model) {
        Guest guest = new Guest();
        guest.setName(model.getName());
        guest.setEmail(model.getEmail());
        guest.setPassword(model.getPassword());
        guest.setAddress(model.getAddress());
        guest.setCity(model.getCity());
        guest.setState(model.getState());
        guest.setZip(model.getZip());
        guest.setPhone(model.getPhone());
        guest.setDob(model.getDob());
        guest.setProfession(model.getProfession());
        guest.setOwner(ownerRepository.findById(model.getOwner_id()).get());
        guestRepository.save(guest);
    }

    public List<GuestDto> getGuest(Integer owner_id) {
        if (owner_id!= null && owner_id != 0) {
            return guestRepository.findByOwnerId(owner_id).stream().map(GuestDto::from).toList();
        }
        else {
            return guestRepository.findAll().stream().map(GuestDto::from).toList();
        }
    }

    public void updateGuest(GuestRequest request) {
        Guest guest = guestRepository.findById(request.getId()).get();
        guest.setName(request.getName());
        guest.setEmail(request.getEmail());
        guest.setPassword(request.getPassword());
        guest.setAddress(request.getAddress());
        guest.setCity(request.getCity());
        guest.setState(request.getState());
        guest.setZip(request.getZip());
        guest.setPhone(request.getPhone());
        guest.setDob(request.getDob());
        guest.setProfession(request.getProfession());
        guestRepository.save(guest);
    }
    public GuestWithStays getGuestWithStays(Integer id) {
        Guest guest = guestRepository.findById(id).orElse(null);
        if (guest == null) {
            return null;
        }
        return GuestWithStays.from(guest);
    }
    public List<GuestDto> findGuest(String name, String phone,String email) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::contains)
                .withMatcher("phone", ExampleMatcher.GenericPropertyMatcher::contains)
                .withMatcher("email",ExampleMatcher.GenericPropertyMatcher::contains)
                .withIgnorePaths("id", "owner", "stays")
                .withIgnoreNullValues();

        Guest guest = Guest.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .build();

        return guestRepository.findAll(Example.of(guest, matcher)).stream().map(GuestDto::from).toList();
    }

}

