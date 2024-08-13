package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {
    private Integer id;
    private String amount;
    private StayWithBedRoom stay;

    public static InvoiceDetail from(Invoice invoice) {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setId(invoice.getId());
        invoiceDetail.setAmount(invoice.getAmount());
        invoiceDetail.setStay(StayWithBedRoom.from(invoice.getStay()));
        return invoiceDetail;
    }
}
