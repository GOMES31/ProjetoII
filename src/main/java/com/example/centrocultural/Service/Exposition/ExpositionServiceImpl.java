package com.example.centrocultural.Service.Exposition;

import com.example.centrocultural.Entity.Client;
import com.example.centrocultural.Entity.Exposition;
import com.example.centrocultural.Repository.ExpositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpositionServiceImpl implements ExpositionService {

    private final ExpositionRepository expositionRepository;

    @Autowired
    public ExpositionServiceImpl(ExpositionRepository theExpositionRepository){
        expositionRepository = theExpositionRepository;
    }

    @Override
    public List<Exposition> findAll() {
        return expositionRepository.findAll();
    }

    @Override
    public Exposition findById(int theId) {
        Optional<Exposition> result = expositionRepository.findById(theId);

       Exposition theExposition = null;

        if (result.isPresent()) {
            theExposition = result.get();
        }
        else {
            // não encontramos a exposição
            throw new RuntimeException("Did not find exposition id - " + theId);
        }

        return theExposition;
    }

    @Override
    public Exposition save(Exposition theExposition) {
        return expositionRepository.save(theExposition);
    }

    @Override
    public void deleteById(int theId) {
        expositionRepository.deleteById(theId);
    }
}
