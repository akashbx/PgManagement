package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceWithPayment {
    private Integer id;
    private String amount;
    private List<PaymentDto> payments;

    public static InvoiceWithPayment from(Invoice invoice) {
        InvoiceWithPayment invoiceWithPayment = new InvoiceWithPayment();
        invoiceWithPayment.setId(invoice.getId());
        invoiceWithPayment.setAmount(invoice.getAmount());
        invoiceWithPayment.setPayments(invoice.getPayments().stream().map(PaymentDto::from).toList());
        return invoiceWithPayment;
    }

}
