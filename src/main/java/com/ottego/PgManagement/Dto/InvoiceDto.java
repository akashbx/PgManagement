package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Integer id;
    private Integer amount;
    private Month month;
    private Integer year;


    public static InvoiceDto from(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setId(invoice.getId());
        invoiceDto.setAmount(invoice.getAmount());
        invoiceDto.setMonth(invoice.getMonth());
        invoiceDto.setYear(invoice.getYear());
        return invoiceDto;
    }
}
