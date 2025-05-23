package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.PaymentDetail;
import com.ottego.PgManagement.Dto.PaymentDto;
import com.ottego.PgManagement.Request.PaymentRequest;
import com.ottego.PgManagement.service.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentServices paymentServices;

    @GetMapping
    public List<PaymentDto> getPayments(@RequestParam(required = false) Integer stay_id) {
        return paymentServices.getPayments(stay_id);
    }

    @PostMapping
    public String addPayment(@RequestBody PaymentRequest paymentRequest) {
        paymentServices.save(paymentRequest);
        return "Payment added successfully";
    }
    @PutMapping
    public String updatePayment(@RequestBody PaymentRequest paymentRequest) {
        paymentServices.update(paymentRequest);
        return "Payment updated successfully";
    }
    @GetMapping("/{id}")
    public PaymentDetail getPaymentById(@PathVariable Integer id) {
        return paymentServices.getPaymentById(id);
    }
}
