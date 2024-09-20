package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Enum.PaymentMode;
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
    private Integer id;
    private String transaction_id;
    private Integer amount;
    private PaymentMode payment_mode;
    private String created_at;
    private String updated_at;
    private InvoiceDto invoice;

    public static PaymentDetail from(Payment payment) {
        PaymentDetail paymentDetail1 = new PaymentDetail();
        paymentDetail1.setId(payment.getId());
        paymentDetail1.setTransaction_id(payment.getTransaction_id());
        paymentDetail1.setAmount(payment.getAmount());
        paymentDetail1.setPayment_mode(payment.getPayment_mode());
        paymentDetail1.setCreated_at(payment.getCreated_at());
        paymentDetail1.setUpdated_at(payment.getUpdated_at());
        paymentDetail1.setInvoice(InvoiceDto.from(payment.getInvoice()));
        return paymentDetail1;
    }
}
