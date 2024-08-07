package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.ComplaintAction;
import com.ottego.PgManagement.model.Enum.ActionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintActionDto {
    private Integer id;
    private ActionStatus status;
    private String description;

    public static ComplaintActionDto from(ComplaintAction complaintAction){
        ComplaintActionDto complaintActionDto = new ComplaintActionDto();
        complaintActionDto.setId(complaintAction.getId());
        complaintActionDto.setStatus(complaintAction.getStatus());
        complaintActionDto.setDescription(complaintAction.getDescription());
        return complaintActionDto;
    }
}
