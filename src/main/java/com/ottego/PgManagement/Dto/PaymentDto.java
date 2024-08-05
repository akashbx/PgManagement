package com.ottego.PgManagement.Dto;

import com.ottego.PgManagement.model.Payment;
import com.ottego.PgManagement.model.Enum.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Integer id;
    private String transaction_id;
    private Integer amount;
    private PaymentMode payment_mode;
    private String created_at;
    private String updated_at;

    public static PaymentDto from(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setTransaction_id(payment.getTransaction_id());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPayment_mode(payment.getPayment_mode());
        paymentDto.setCreated_at(payment.getCreated_at());
        paymentDto.setUpdated_at(payment.getUpdated_at());
        return paymentDto;
    }
}
