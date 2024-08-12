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
public class StayDetails {
    private Integer id;
    private String checkIn;
    private String checkOut;
    private GuestDto guest;
    private List<InvoiceWithPayment> invoice;
    private List<ComplaintDto> complaint;

    public static StayDetails from(Stay stay) {
        StayDetails stayDetails = new StayDetails();
        stayDetails.setId(stay.getId());
        stayDetails.setCheckIn(stay.getCheckIn());
        stayDetails.setCheckOut(stay.getCheckOut());
        stayDetails.setGuest(GuestDto.from(stay.getGuest()));
        stayDetails.setInvoice(stay.getInvoice().stream().map(InvoiceWithPayment::from).toList());
        stayDetails.setComplaint(stay.getComplaint().stream().map(ComplaintDto::from).toList());
        return stayDetails;
    }
}
