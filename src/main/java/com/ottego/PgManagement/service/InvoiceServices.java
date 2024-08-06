package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.InvoiceWithPayment;
import com.ottego.PgManagement.Request.InvoiceRequest;
import com.ottego.PgManagement.model.Invoice;
import com.ottego.PgManagement.model.Stay;
import com.ottego.PgManagement.repository.InvoiceRepository;
import com.ottego.PgManagement.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServices {

    @Autowired
    private StayRepository StayRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;


    public List<InvoiceWithPayment> getInvoices() {
        return invoiceRepository.findAll().stream().map(InvoiceWithPayment::from).toList();
    }

    public void save(InvoiceRequest model) {
        Invoice invoice = new Invoice();
        invoice.setAmount(model.getAmount());

        model.getStayId();

        Stay stay = StayRepository.findById(model.getStayId()).get();

        invoice.setStay(stay);


        invoiceRepository.save(invoice);


    }

    public void update(InvoiceRequest request) {
        Invoice invoice = invoiceRepository.findById(request.getId()).get();
        invoice.setAmount(request.getAmount());
        invoice.setStay(StayRepository.findById(request.getStayId()).get());
        invoiceRepository.save(invoice);
    }
}
