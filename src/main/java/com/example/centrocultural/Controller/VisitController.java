package com.example.centrocultural.Controller;

import com.example.centrocultural.Entity.Invoice;
import com.example.centrocultural.Entity.Visit;
import com.example.centrocultural.Service.Visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService theVisitService){
        visitService = theVisitService;
    }

    @GetMapping("/visits/{visitId}")
    public Visit getVisit(@PathVariable int visitId){

        Visit theVisit = visitService.findById(visitId);

        // lança uma exceção se o valor retornado for null
        if(theVisit == null){
            throw new RuntimeException("Visit id not found - " + visitId);
        }

        return theVisit;
    }

    @PostMapping("/visits")
    public Visit addVisit(@RequestBody Visit theVisit){

        // No caso de utilizador passar um Id como parametro, definir o Id como 0 para ser gerado automaticamente
        // isto é para forçar a guardar um item novo, e não atualizar um item já existente

        theVisit.setId(0);

        Visit dbVisit = visitService.save(theVisit);

        return dbVisit;
    }

    @PutMapping("/visits")
    public Visit updateVisit(@RequestBody Visit theVisit) {

        Visit dbVisit = visitService.save(theVisit);

        return dbVisit;
    }

    @DeleteMapping("/visits{visitId}")
    public String deleteVisit(@PathVariable int visitId) {

        Visit tempVisit = visitService.findById(visitId);

        // lança uma exceção se o valor retornado for null
        if(tempVisit== null){
            throw new RuntimeException("Visit id not found - " + visitId);
        }

        visitService.deleteById(visitId);

        return "Deleted visit id - " + visitId;
    }
}
