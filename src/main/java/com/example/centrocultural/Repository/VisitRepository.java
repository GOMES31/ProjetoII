package com.example.centrocultural.Repository;

import com.example.centrocultural.Entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:8080/api/visits")
public interface VisitRepository extends JpaRepository<Visit, Integer> {

    // Não é necessário código nenhum apenas só se for uma query especifica

}
