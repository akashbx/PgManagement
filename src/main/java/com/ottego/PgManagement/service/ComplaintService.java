package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.ComplaintDetail;
import com.ottego.PgManagement.Dto.ComplaintDto;
import com.ottego.PgManagement.Request.ComplaintRequest;
import com.ottego.PgManagement.model.Complaint;
import com.ottego.PgManagement.model.Enum.ComplaintType;
import com.ottego.PgManagement.model.Stay;
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

    public List<ComplaintDto> getComplaints(Integer stay_id, Integer pg_id) {
        if (stay_id != null && stay_id != 0) {
            return complaintRepository.findAllByStay_Id(stay_id).stream().map(ComplaintDto::from).toList();
        } else if (pg_id != null && pg_id != 0) {
            return complaintRepository.findAllByStay_Bed_Room_Pg_Id(pg_id).stream().map(ComplaintDto::from).toList();
        } else {
            return complaintRepository.findAll().stream().map(ComplaintDto::from).toList();
        }
    }

    public void save(ComplaintRequest model) {
        Complaint complaint = new Complaint();

        complaint.setDescription(model.getDescription());
        complaint.setType(ComplaintType.valueOf(model.getType()));

        model.getStay_id();


        Stay stay = stayRepository.findById(model.getStay_id()).get();


        complaint.setStay(stay);

        complaintRepository.save(complaint);
    }

    public void update(ComplaintRequest request) {
        Complaint complaint = complaintRepository.findById(request.getId()).get();
        complaint.setDescription(request.getDescription());
        complaint.setType(ComplaintType.valueOf(request.getType()));
        complaint.setStay(stayRepository.findById(request.getStay_id()).get());
        complaintRepository.save(complaint);
    }

    public ComplaintDto getComplaintById(Integer id) {
        return ComplaintDto.from(complaintRepository.findById(id).get());
    }

    public ComplaintDetail getComplaintDetailById(Integer id) {
        return ComplaintDetail.from(complaintRepository.findById(id).get());
    }


    public List<ComplaintDto> getComplaintsByPgId(Integer pg_id) {
        return complaintRepository.findAllByStay_Bed_Room_Pg_Id(pg_id).stream().map(ComplaintDto::from).toList();

    }
}
