package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Request.PaymentRequest;
import com.ottego.PgManagement.model.Invoice;
import com.ottego.PgManagement.model.Payment;
import com.ottego.PgManagement.repository.InvoiceRepository;
import com.ottego.PgManagement.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    public void save(PaymentRequest model) {
        Payment payment = new Payment();

        payment.setTransaction_id(model.getTransaction_id());
        payment.setAmount(model.getAmount());
        payment.setPayment_mode(model.getPayment_mode());
        payment.setCreated_at(model.getCreated_at());
        payment.setUpdated_at(model.getUpdated_at());

        model.getInvoice_id();

        Invoice invoice = invoiceRepository.findById(model.getInvoice_id()).get();

        payment.setInvoice(invoice);

        paymentRepository.save(payment);
    }
}
