package com.example.centrocultural.Service.Invoice;

import com.example.centrocultural.Entity.Exposition;
import com.example.centrocultural.Entity.Invoice;
import com.example.centrocultural.Repository.ExpositionRepository;
import com.example.centrocultural.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository theInvoiceRepository){
        invoiceRepository = theInvoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(int theId){
        Optional<Invoice> result = invoiceRepository.findById(theId);

        Invoice theInvoice = null;

        if (result.isPresent()) {
            theInvoice = result.get();
        }
        else {
            // não encontramos a fatura
            throw new RuntimeException("Did not find invoice id - " + theId);
        }

        return theInvoice;
    }

    @Override
    public Invoice save(Invoice theInvoice) {
        return invoiceRepository.save(theInvoice);
    }

    @Override
    public void deleteById(int theId) {
        invoiceRepository.deleteById(theId);
    }
}

