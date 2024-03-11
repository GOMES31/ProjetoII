package com.example.centrocultural.Service.Client;

import com.example.centrocultural.Entity.Client;
import com.example.centrocultural.Repository.ClientRepository;
import com.example.centrocultural.Service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository theClientRepository){
        clientRepository = theClientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int theId) {
        Optional<Client> result = clientRepository.findById(theId);

        Client theClient = null;

        if (result.isPresent()) {
            theClient = result.get();
        }
        else {
            // não encontramos o cliente
            throw new RuntimeException("Did not find client id - " + theId);
        }

        return theClient;
    }

    @Override
    public Client save(Client theClient) {
        return clientRepository.save(theClient);
    }

    @Override
    public void deleteById(int theId) {
        clientRepository.deleteById(theId);
    }



}
