package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.InvoiceDetail;
import com.ottego.PgManagement.Dto.InvoiceWithPayment;
import com.ottego.PgManagement.Request.InvoiceRequest;
import com.ottego.PgManagement.model.Invoice;
import com.ottego.PgManagement.service.InvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceServices invoiceServices;

    @GetMapping
    public List<InvoiceWithPayment> getInvoice(@RequestParam(required = false) Integer stay_id) {
        return invoiceServices.getInvoices(stay_id);
    }

    @PostMapping
    public String addInvoice(@RequestBody InvoiceRequest request) {
        invoiceServices.save(request);
        return "Invoice added successfully";
    }

    @PutMapping
    public String updateInvoice(@RequestBody InvoiceRequest request) {
        invoiceServices.update(request);
        return "Invoice updated successfully";
    }


    @GetMapping("/{id}")
    public InvoiceDetail getInvoiceById(@PathVariable Integer id) {
        return invoiceServices.getInvoiceById(id);
    }

    @PostMapping("/generate")
    public List<InvoiceDetail> getInvoiceByStayId() {
        return invoiceServices.generateRentInvoices();
    }
}
