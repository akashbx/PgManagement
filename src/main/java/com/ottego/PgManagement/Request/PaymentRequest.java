package com.ottego.PgManagement.Request;

import com.ottego.PgManagement.model.Enum.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private Integer id;
    private String transaction_id;
    private Integer amount;
    private PaymentMode payment_mode;
    private String created_at;
    private String updated_at;
    private Integer invoice_id;
}
