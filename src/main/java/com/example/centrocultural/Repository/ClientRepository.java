package com.example.centrocultural.Repository;

import com.example.centrocultural.Entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface ClientRepository extends JpaRepository <Client, Integer>{

    // Não é necessário código nenhum apenas só se for uma query especifica
}
