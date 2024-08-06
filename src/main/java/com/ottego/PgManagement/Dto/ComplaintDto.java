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
public class ComplaintDto {
    private Integer id;
    private ComplaintType type;
    private String description;

    public static ComplaintDto from(Complaint complaint) {
        ComplaintDto complaintDto = new ComplaintDto();
        complaintDto.setId(complaint.getId());
        complaintDto.setType(complaint.getType());
        complaintDto.setDescription(complaint.getDescription());
        return complaintDto;
    }

}
