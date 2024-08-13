package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.ComplaintActionDetail;
import com.ottego.PgManagement.Dto.ComplaintActionDto;
import com.ottego.PgManagement.Request.ComplaintActionRequest;
import com.ottego.PgManagement.model.Complaint;
import com.ottego.PgManagement.model.ComplaintAction;
import com.ottego.PgManagement.model.Enum.ActionStatus;
import com.ottego.PgManagement.repository.ComplaintActionRepository;
import com.ottego.PgManagement.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintActionService {
    @Autowired
    private ComplaintActionRepository complaintActionRepository;
    @Autowired
    private ComplaintRepository complaintRepository;
    public List<ComplaintActionDto> getComplaintAction(){
        return complaintActionRepository.findAll().stream().map(ComplaintActionDto::from).toList();
    }
    public void save(ComplaintActionRequest model){
        ComplaintAction complaintAction = new ComplaintAction();

        complaintAction.setStatus(ActionStatus.valueOf(model.getStatus()));
        complaintAction.setDescription(model.getDescription());
        model.getComplaint_id();
        Complaint complaint = complaintRepository.findById(model.getComplaint_id()).get();

        complaintAction.setComplaint(complaint);
        complaintActionRepository.save(complaintAction);
    }

    public void update(ComplaintActionRequest request){
        ComplaintAction complaintAction = complaintActionRepository.findById(request.getId()).get();
        complaintAction.setStatus(ActionStatus.valueOf(request.getStatus()));
        complaintAction.setDescription(request.getDescription());
        complaintAction.setComplaint(complaintRepository.findById(request.getComplaint_id()).get());
        complaintActionRepository.save(complaintAction);
    }

    public ComplaintActionDto getComplaintActionById(Integer id) {
        return ComplaintActionDto.from(complaintActionRepository.findById(id).get());
    }

    public ComplaintActionDetail getComplaintActionDetailById(Integer id) {
        return ComplaintActionDetail.from(complaintActionRepository.findById(id).get());
    }
}
