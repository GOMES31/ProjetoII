package com.example.centrocultural.Service.Visit;

import com.example.centrocultural.Entity.Visit;

import java.util.List;

public interface VisitService {

    List<Visit> findAll();

    Visit findById(int theId);

    Visit save(Visit theVisit);

    void deleteById(int theId);
}
