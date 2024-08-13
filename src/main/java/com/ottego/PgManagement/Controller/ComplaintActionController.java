package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.ComplaintActionDetail;
import com.ottego.PgManagement.Dto.ComplaintActionDto;
import com.ottego.PgManagement.Request.ComplaintActionRequest;
import com.ottego.PgManagement.service.ComplaintActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/action")
public class ComplaintActionController {
    @Autowired
    private ComplaintActionService complaintActionService;

    @GetMapping
    public List<ComplaintActionDto> getComplaintAction() {
        return complaintActionService.getComplaintAction();
    }

    @PutMapping
    public String updateComplaintAction(@RequestBody ComplaintActionRequest request) {
        complaintActionService.update(request);
        return "Complaint action updated successfully";
    }

    @PostMapping
    public String addComplaintAction(@RequestBody ComplaintActionRequest request) {
        complaintActionService.save(request);
        return "Complaint action added successfully";
    }
    @GetMapping("/{id}")
    public ComplaintActionDto getComplaintActionId(@PathVariable Integer id) {
        return complaintActionService.getComplaintActionById(id);
    }

    @GetMapping("/detail/{id}")
    public ComplaintActionDetail getComplaintActionDetailId(@PathVariable Integer id) {
        return complaintActionService.getComplaintActionDetailById(id);
    }
}
