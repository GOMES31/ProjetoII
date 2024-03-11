package com.example.centrocultural.Service.Exposition;

import com.example.centrocultural.Entity.Client;
import com.example.centrocultural.Entity.Exposition;

import java.util.List;

public interface ExpositionService {
    List<Exposition> findAll();

    Exposition findById(int theId);

    Exposition save(Exposition theExposition);

    void deleteById(int theId);
}
