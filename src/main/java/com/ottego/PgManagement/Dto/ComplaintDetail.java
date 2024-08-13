package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Complaint;
import com.ottego.PgManagement.model.Enum.ComplaintType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDetail {
    private Integer id;
    private ComplaintType type;
    private String description;
    private StayWithBedRoom stay;

    public static ComplaintDetail from(Complaint complaint) {
        ComplaintDetail complaintDetail = new ComplaintDetail();
        complaintDetail.setId(complaint.getId());
        complaintDetail.setType(complaint.getType());
        complaintDetail.setDescription(complaint.getDescription());
        complaintDetail.setStay(StayWithBedRoom.from(complaint.getStay()));
        return complaintDetail;
    }
}
