package com.example.centrocultural.Service.Client;

import com.example.centrocultural.Entity.Client;
import com.example.centrocultural.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client findById(int theId);

    Client save(Client theClient);

    void deleteById(int theId);
}
