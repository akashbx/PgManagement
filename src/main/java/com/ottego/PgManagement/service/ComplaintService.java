package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.ComplaintDto;
import com.ottego.PgManagement.Request.ComplaintRequest;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Complaint;
import com.ottego.PgManagement.model.Enum.ComplaintType;
import com.ottego.PgManagement.model.Stay;
import com.ottego.PgManagement.repository.BedRepository;
import com.ottego.PgManagement.repository.ComplaintRepository;
import com.ottego.PgManagement.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private StayRepository stayRepository;

   public List<ComplaintDto> getComplaints() {
       return complaintRepository.findAll().stream().map(ComplaintDto::from).toList();
   }

    public void save(ComplaintRequest model) {
        Complaint complaint = new Complaint();

        complaint.setDescription(model.getDescription());
        complaint.setType(ComplaintType.valueOf(model.getType()));

        model.getStayId();

        Stay stay = stayRepository.findById(model.getStayId()).get();

        complaint.setStay(stay);

        complaintRepository.save(complaint);
    }

    public void update(ComplaintRequest request) {
        Complaint complaint = complaintRepository.findById(request.getId()).get();
        complaint.setDescription(request.getDescription());
        complaint.setType(ComplaintType.valueOf(request.getType()));
        complaint.setStay(stayRepository.findById(request.getStayId()).get());
        complaintRepository.save(complaint);
    }
}
