package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.InvoiceWithPayment;
import com.ottego.PgManagement.Dto.PaymentDto;
import com.ottego.PgManagement.Request.PaymentRequest;
import com.ottego.PgManagement.model.Invoice;
import com.ottego.PgManagement.model.Payment;
import com.ottego.PgManagement.repository.InvoiceRepository;
import com.ottego.PgManagement.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServices {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<PaymentDto> getPayments() {
        return paymentRepository.findAll().stream().map(PaymentDto::from).toList();
    }

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
    public void update(PaymentRequest request) {
        Payment payment = paymentRepository.findById(request.getId()).get();
        payment.setTransaction_id(request.getTransaction_id());
        payment.setAmount(request.getAmount());
        payment.setPayment_mode(request.getPayment_mode());
        payment.setCreated_at(request.getCreated_at());
        payment.setUpdated_at(request.getUpdated_at());
        payment.setInvoice(invoiceRepository.findById(request.getInvoice_id()).get());
        paymentRepository.save(payment);
    }
}
