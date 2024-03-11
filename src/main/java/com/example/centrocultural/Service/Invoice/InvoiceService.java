package com.example.centrocultural.Service.Invoice;

import com.example.centrocultural.Entity.Exposition;
import com.example.centrocultural.Entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> findAll();

    Invoice findById(int theId);

    Invoice save(Invoice theInvoice);

    void deleteById(int theId);
}
