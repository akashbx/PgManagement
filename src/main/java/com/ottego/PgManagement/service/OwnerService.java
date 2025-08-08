package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.OwnerDetail;
import com.ottego.PgManagement.Dto.OwnerDto;
import com.ottego.PgManagement.Request.OwnerRequest;
import com.ottego.PgManagement.model.Owner;
import com.ottego.PgManagement.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public void save (OwnerRequest model) {
        Owner owner = new Owner();
        owner.setName(model.getName());
        owner.setEmail(model.getEmail());
        owner.setPhone(model.getPhone());
        owner.setPassword(model.getPassword());
        ownerRepository.save(owner);
    }


    public void update(OwnerRequest request) {
        Owner owner = ownerRepository.findById(request.getId()).get();
        owner.setName(request.getName());
        owner.setEmail(request.getEmail());
        owner.setPhone(request.getPhone());
        owner.setPassword(request.getPassword());
        ownerRepository.save(owner);
    }

    public OwnerDetail getOwnerDetail(Integer id) {
        Owner owner = ownerRepository.findById(id).get();
        return OwnerDetail.from(owner);
    }

    public List<OwnerDto> getOwners() {
        return ownerRepository.findAll().stream().map(OwnerDto::from).toList();
    }

    public OwnerDto getOwnerById(Integer id) {
        return OwnerDto.from(ownerRepository.findById(id).get());
    }

}
