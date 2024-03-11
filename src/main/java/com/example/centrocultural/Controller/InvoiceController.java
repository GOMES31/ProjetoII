package com.example.centrocultural.Controller;

import com.example.centrocultural.Entity.Exposition;
import com.example.centrocultural.Entity.Invoice;
import com.example.centrocultural.Service.Invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService theInvoiceService){
        invoiceService = theInvoiceService;
    }

    @GetMapping("/invoices/{invoiceId}")
    public Invoice getInvoice(@PathVariable int invoiceId){

        Invoice theInvoice = invoiceService.findById(invoiceId);

        // lança uma exceção se o valor retornado for null
        if(theInvoice == null){
            throw new RuntimeException("Invoice id not found - " + invoiceId);
        }

        return theInvoice;
    }

    @PostMapping("/invoices")
    public Invoice addInvoice(@RequestBody Invoice theInvoice){

        // No caso de utilizador passar um Id como parametro, definir o Id como 0 para ser gerado automaticamente
        // isto é para forçar a guardar um item novo, e não atualizar um item já existente

        theInvoice.setId(0);

        Invoice dbInvoice = invoiceService.save(theInvoice);

        return dbInvoice;
    }

    @PutMapping("/invoices")
    public Invoice updateInvoice(@RequestBody Invoice theInvoice) {

        Invoice dbInvoice = invoiceService.save(theInvoice);

        return dbInvoice;
    }

    @DeleteMapping("/invoices{invoiceId}")
    public String deleteInvoice(@PathVariable int invoiceId) {

        Invoice tempInvoice = invoiceService.findById(invoiceId);

        // lança uma exceção se o valor retornado for null
        if(tempInvoice== null){
            throw new RuntimeException("Invoice id not found - " + invoiceId);
        }

        invoiceService.deleteById(invoiceId);

        return "Deleted invoice id - " + invoiceId;
    }

}
