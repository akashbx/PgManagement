package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.StayDetails;
import com.ottego.PgManagement.Request.StayRequest;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Guest;
import com.ottego.PgManagement.model.Stay;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.GuestRepository;
import com.ottego.PgManagement.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StayService {

    @Autowired
    StayRepository stayRepository;

    @Autowired
    BedRepository bedRepository;

    @Autowired
    GuestRepository guestRepository;

    public void save(StayRequest model) {
        Stay stay = new Stay();
        stay.setCheckIn(model.getCheckIn());
        stay.setCheckOut(model.getCheckOut());

        model.getBed_id();
        model.getGuest_id();

        Bed bed = bedRepository.findById(model.getBed_id()).get();
        Guest guest = guestRepository.findById(model.getGuest_id()).get();

        stay.setBed(bed);
        stay.setGuest(guest);

        stayRepository.save(stay);


    }

    public void update(StayRequest request) {
        Stay stay = stayRepository.findById(request.getId()).get();
        stay.setCheckIn(request.getCheckIn());
        stay.setCheckOut(request.getCheckOut());
        request.getBed_id();
        request.getGuest_id();
        Bed bed = bedRepository.findById(request.getBed_id()).get();
        Guest guest = guestRepository.findById(request.getGuest_id()).get();
        stay.setBed(bed);
        stay.setGuest(guest);
        stayRepository.save(stay);
    }

    public List<StayDetails> getAllStays() {
        return stayRepository.findAll().stream().map(StayDetails::from).toList();
    }

    public StayDetails getStayById(Integer id) {
        return StayDetails.from(stayRepository.findById(id).get());
    }
}
