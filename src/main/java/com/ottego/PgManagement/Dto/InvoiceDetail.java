package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {
    private Integer id;
    private Integer amount;
    private Month month;
    private Integer year;
    private StayWithBedRoom stay;

    public static InvoiceDetail from(Invoice invoice) {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setId(invoice.getId());
        invoiceDetail.setAmount(invoice.getAmount());
        invoiceDetail.setMonth(invoice.getMonth());
        invoiceDetail.setYear(invoice.getYear());
        invoiceDetail.setStay(StayWithBedRoom.from(invoice.getStay()));
        return invoiceDetail;
    }
}
