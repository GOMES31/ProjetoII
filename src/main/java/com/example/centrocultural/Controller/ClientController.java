package com.example.centrocultural.Controller;

import com.example.centrocultural.Entity.Client;
import com.example.centrocultural.Entity.Exposition;
import com.example.centrocultural.Service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{clientId}")
    public Client getClient(@PathVariable int clientId) {

        Client theClient = clientService.findById(clientId);

        // lança uma exceção se o valor retornado for null
        if (theClient == null) {
            throw new RuntimeException("Client id not found - " + clientId);
        }

        return theClient;
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client theClient){

        // No caso de utilizador passar um Id como parametro, definir o Id como 0 para ser gerado automaticamente
        // isto é para forçar a guardar um item novo, e não atualizar um item já existente

        theClient.setId(0);

        Client dbClient = clientService.save(theClient);

        return dbClient;

    }

    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client theClient) {

        Client dbClient = clientService.save(theClient);

        return dbClient;
    }

    @DeleteMapping("/clients/{clientId}")
    public String deleteClient(@PathVariable int clientId) {

        Client tempClient = clientService.findById(clientId);

        // lança uma exceção se o valor retornado for null
        if(tempClient == null){
            throw new RuntimeException("Client id not found - " + clientId);
        }

        clientService.deleteById(clientId);

        return "Deleted client id - " + clientId;
    }
}
