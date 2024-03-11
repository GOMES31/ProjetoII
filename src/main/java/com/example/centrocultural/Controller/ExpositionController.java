package com.example.centrocultural.Controller;

import com.example.centrocultural.Entity.Client;
import com.example.centrocultural.Entity.Exposition;
import com.example.centrocultural.Service.Exposition.ExpositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expositions")
public class ExpositionController {

    private final ExpositionService expositionService;

    @Autowired
    public ExpositionController(ExpositionService theExpositionService){
        expositionService = theExpositionService;
    }

    @GetMapping("/expositions/{expositionId}")
    public Exposition getExposition(@PathVariable int expositionId) {

        Exposition theExposition = expositionService.findById(expositionId);

        if (theExposition== null) {
            throw new RuntimeException("Exposition id not found - " + expositionId);
        }

        return theExposition;
    }

    @PostMapping("/expositions")
    public Exposition addExposition(@RequestBody Exposition theExposition){

        // No caso de utilizador passar um Id como parametro, definir o Id como 0 para ser gerado automaticamente
        // isto é para forçar a guardar um item novo, e não atualizar um item já existente

        theExposition.setId(0);

        Exposition dbExposition = expositionService.save(theExposition);

        return dbExposition;

    }

    @PutMapping("/expositions")
    public Exposition updateExposition(@RequestBody Exposition theExposition) {

        Exposition dbExposition = expositionService.save(theExposition);

        return dbExposition;
    }

    @DeleteMapping("/expositions{expositionId}")
    public String deleteExposition(@PathVariable int expositionId) {

        Exposition tempExposition = expositionService.findById(expositionId);

        // lança uma exceção se o valor retornado for null
        if(tempExposition == null){
            throw new RuntimeException("Exposition id not found - " + expositionId);
        }

        expositionService.deleteById(expositionId);

        return "Deleted exposition id - " + expositionId;
    }
}
