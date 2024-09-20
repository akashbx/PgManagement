package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Stay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StayDetails {
    private Integer id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private GuestDto guest;
    private BedRoom bed;
    private List<InvoiceDto> invoices;
    private List<ComplaintDto> complaints;


    public static StayDetails from(Stay stay) {
        StayDetails stayDetails = new StayDetails();
        stayDetails.setId(stay.getId());
        stayDetails.setCheckIn(stay.getCheckIn());
        stayDetails.setCheckOut(stay.getCheckOut());
        stayDetails.setGuest(GuestDto.from(stay.getGuest()));
        stayDetails.setBed(BedRoom.from(stay.getBed()));
        stayDetails.setInvoices(stay.getInvoice().stream().map(InvoiceDto::from).toList());
        stayDetails.setComplaints(stay.getComplaint().stream().map(ComplaintDto::from).toList());
        return stayDetails;
    }
}
