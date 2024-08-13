package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.ComplaintAction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintActionDetail {
    private ComplaintActionDto complaintActions;
    private ComplaintDetail complaints;

    public static ComplaintActionDetail from(ComplaintAction complaintAction) {
        ComplaintActionDetail complaintActionDetail = new ComplaintActionDetail();
        complaintActionDetail.setComplaintActions(ComplaintActionDto.from(complaintAction));
        complaintActionDetail.setComplaints(ComplaintDetail.from(complaintAction.getComplaint()));
        return complaintActionDetail;
    }
}
