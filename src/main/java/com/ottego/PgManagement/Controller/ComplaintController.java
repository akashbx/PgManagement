package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.ComplaintDetail;
import com.ottego.PgManagement.Dto.ComplaintDto;
import com.ottego.PgManagement.Request.ComplaintRequest;
import com.ottego.PgManagement.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @GetMapping
    public List<ComplaintDto> getComplaint() {
        return complaintService.getComplaints();
    }

    @PostMapping
    public String addComplaint(@RequestBody ComplaintRequest request) {
        complaintService.save(request);
        return "Complaint added successfully";
    }

    @PutMapping
    public String updateComplaint(@RequestBody ComplaintRequest request) {
        complaintService.update(request);
        return "Complaint updated successfully";
    }
    @GetMapping("/{id}")
    public ComplaintDto getComplaintId(@PathVariable Integer id) {
        return complaintService.getComplaintById(id);
    }

    @GetMapping("detail/{id}")
    public ComplaintDetail getComplaintDetailById(@PathVariable Integer id) {
        return complaintService.getComplaintDetailById(id);
    }
}
