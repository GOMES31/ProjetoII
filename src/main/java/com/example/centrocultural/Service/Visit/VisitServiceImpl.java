package com.example.centrocultural.Service.Visit;

import com.example.centrocultural.Entity.Invoice;
import com.example.centrocultural.Entity.Visit;
import com.example.centrocultural.Repository.InvoiceRepository;
import com.example.centrocultural.Repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitServiceImpl(VisitRepository theVisitRepository){
        visitRepository = theVisitRepository;
    }

    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public Visit findById(int theId){
        Optional<Visit> result = visitRepository.findById(theId);

        Visit theVisit = null;

        if (result.isPresent()) {
            theVisit = result.get();
        }
        else {
            // não encontramos a visita
            throw new RuntimeException("Did not find visit id - " + theId);
        }

        return theVisit;
    }

    @Override
    public Visit save(Visit theVisit) {
        return visitRepository.save(theVisit);
    }

    @Override
    public void deleteById(int theId) {
        visitRepository.deleteById(theId);
    }
}
