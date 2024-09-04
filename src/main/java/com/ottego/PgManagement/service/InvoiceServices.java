package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.InvoiceDetail;
import com.ottego.PgManagement.Dto.InvoiceWithPayment;
import com.ottego.PgManagement.Dto.StayWithBedRoom;
import com.ottego.PgManagement.Request.InvoiceRequest;
import com.ottego.PgManagement.model.Bed;
import com.ottego.PgManagement.model.Invoice;
import com.ottego.PgManagement.model.Stay;
import com.ottego.PgManagement.repository.InvoiceRepository;
import com.ottego.PgManagement.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServices {
    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StayService stayService;


    public List<InvoiceWithPayment> getInvoices(Integer stay_id) {
        if(stay_id!= null && stay_id != 0) {
            return invoiceRepository.findAllByStay_Id(stay_id).stream().map(InvoiceWithPayment::from).toList();
        }
        else {
            return invoiceRepository.findAll().stream().map(InvoiceWithPayment::from).toList();
        }
    }
    public InvoiceDetail getInvoiceById(Integer id) {
        return InvoiceDetail.from(invoiceRepository.findById(id).get());
    }

    public void save(InvoiceRequest model) {
        Invoice invoice = new Invoice();
//        invoice.setAmount(String.valueOf(calculateRent(model.getStayId())));

        Stay stay = stayRepository.findById(model.getStayId()).get();

        invoice.setStay(stay);

        invoiceRepository.save(invoice);
    }

    public void update(InvoiceRequest request) {
        Invoice invoice = invoiceRepository.findById(request.getId()).get();
//        invoice.setAmount(String.valueOf(request.getStayId()));
        invoice.setStay(stayRepository.findById(request.getStayId()).get());
        invoiceRepository.save(invoice);
    }
    public List<InvoiceDetail> generateRentInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        List<Stay> stays = stayRepository.findAllByCheckOutIsNull();
        for (Stay stay : stays) {
            if (stay.getCheckOut() == null) {
                Invoice invoice = new Invoice();
                invoice.setStay(stay);
                if(stay.daysStayed()<= 15) {
                    invoice.setAmount(stay.getBed().getPrice()/30 * stay.daysStayed() + "");
                } else
                    invoice.setAmount(stay.getBed().getPrice()+"");
               invoices.add(invoice);
            }
        }
        System.out.println(invoices.size());

        return invoiceRepository.saveAll(invoices).stream().map(InvoiceDetail::from).toList();
    }
}
