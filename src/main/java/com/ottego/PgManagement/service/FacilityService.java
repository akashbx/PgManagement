package com.ottego.PgManagement.service;


import com.ottego.PgManagement.Dto.FacilityDto;
import com.ottego.PgManagement.Request.FacilityRequest;
import com.ottego.PgManagement.model.Enum.PgFacility;
import com.ottego.PgManagement.model.Facility;
import com.ottego.PgManagement.repository.FacilityRepository;
import com.ottego.PgManagement.repository.PgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private PgRepository pgRepository;

    public void save(FacilityRequest model) {
        Facility facility = new Facility();
        facility.setName(PgFacility.valueOf(model.getName()));
        facility.setPg(pgRepository.findById(model.getPgId()).get());
        facilityRepository.save(facility);
    }
    public void update(FacilityRequest model) {
        Facility facility = facilityRepository.findById(model.getId()).get();
        facility.setName(PgFacility.valueOf(model.getName()));
        facility.setPg(pgRepository.findById(model.getPgId()).get());
        facilityRepository.save(facility);
    }
    public List<FacilityDto> getFacilities() {

        return facilityRepository.findAll().stream().map(FacilityDto::from).toList();
    }
}
