package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Stay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StayDto {
    private Integer id;
    private String checkIn;
    private String checkOut;
    private GuestDto guest;
    private List<InvoiceWithPayment> invoice;
    private List<ComplaintDto> complaint;

    public static StayDto from(Stay stay) {
        StayDto stayDto = new StayDto();
        stayDto.setId(stay.getId());
        stayDto.setCheckIn(stay.getCheckIn());
        stayDto.setCheckOut(stay.getCheckOut());
        stayDto.setGuest(GuestDto.from(stay.getGuest()));
        stayDto.setInvoice(stay.getInvoice().stream().map(InvoiceWithPayment::from).toList());
        stayDto.setComplaint(stay.getComplaint().stream().map(ComplaintDto::from).toList());
        return stayDto;
    }
}
