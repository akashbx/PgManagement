package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetail {
    private PaymentDto payment;
    private InvoiceDetail invoices;

    public static PaymentDetail from(Payment payment) {
        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setPayment(PaymentDto.from(payment));
        paymentDetail.setInvoices(InvoiceDetail.from(payment.getInvoice()));
        return paymentDetail;
    }
}
