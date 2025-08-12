package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.StayDetails;
import com.ottego.PgManagement.Dto.StayDto;
import com.ottego.PgManagement.Dto.StayShortDto;
import com.ottego.PgManagement.Dto.StayWithBedRoom;
import com.ottego.PgManagement.Request.StayRequest;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Diner;
import com.ottego.PgManagement.model.Guest;
import com.ottego.PgManagement.model.Stay;
import com.ottego.PgManagement.repository.*;
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

    @Autowired
    private DinerRepository dinerRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

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
        Stay stay = stayRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("Stay not found with id: " + request.getId()));

        Bed bed = bedRepository.findById(request.getBed_id())
                .orElseThrow(() -> new IllegalArgumentException("Bed not found with id: " + request.getBed_id()));

        Guest guest = guestRepository.findById(request.getGuest_id())
                .orElseThrow(() -> new IllegalArgumentException("Guest not found with id: " + request.getGuest_id()));

        stay.setCheckIn(request.getCheckIn());
        stay.setCheckOut(request.getCheckOut());
        stay.setBed(bed);
        stay.setGuest(guest);
        stayRepository.save(stay);
    }


    public List<StayShortDto> getAllStays(Integer bedId, Integer guestId, Integer pgId, String status) {

        // Fetch all stays first
        List<Stay> stays = stayRepository.findAll();

        // Filter by bed_id
        if (bedId != null && bedId != 0) {
            stays = stays.stream()
                    .filter(stay -> stay.getBed() != null && stay.getBed().getId().equals(bedId))
                    .toList();
        }

        // Filter by guest_id
        if (guestId != null && guestId != 0) {
            stays = stays.stream()
                    .filter(stay -> stay.getGuest() != null && stay.getGuest().getId().equals(guestId))
                    .toList();
        }

        // Filter by pg_id (SuperParent ID)
        if (pgId != null && pgId != 0) {
            stays = stays.stream()
                    .filter(stay -> stay.getBed() != null &&
                            stay.getBed().getRoom() != null &&
                            stay.getBed().getRoom().getPg() != null &&
                            stay.getBed().getRoom().getPg().getId().equals(pgId))
                    .toList();
        }


        // Filter by status
        if (status != null && !status.isEmpty()) {
            if (status.equalsIgnoreCase("checked_in")) {
                stays = stays.stream()
                        .filter(stay -> stay.getCheckOut() == null)
                        .toList();
            } else if (status.equalsIgnoreCase("checked_out")) {
                stays = stays.stream()
                        .filter(stay -> stay.getCheckOut() != null)
                        .toList();
            }
        }

        return stays.stream().map(StayShortDto::from).toList();
    }


    public StayDetails getStayById(Integer id) {
        return StayDetails.from(stayRepository.findById(id).get());
    }

    public StayWithBedRoom StayWithBedRoom(Integer id) {
        return StayWithBedRoom.from(stayRepository.findById(id).get());
    }
    public List<StayDto> getStayByPg_id(Integer pg_id) {
        return stayRepository.findBySuperParentId(pg_id).stream().map(StayDto::from).toList();
    }

    public int calculateTotalCost(int stayId) {

        List<Diner> diners = stayRepository.findById(stayId).get().getDiners();

        int totalCost = 0;
        for (Diner diner : diners) {
            totalCost += diner.getMeal().calculateMealCost();
        }
        return totalCost;
    }
    public List<StayWithBedRoom> getActiveStays() {
        return stayRepository.findAllByCheckOutIsNull().stream().map(StayWithBedRoom::from).toList();
    }



}
