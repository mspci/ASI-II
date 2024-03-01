package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ds.springproj.entities.Client;
import tn.esprit.tic.ds.springproj.services.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final IClientService clientService;

    // http://localhost:8089/menu/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
        List<Client> listClients = clientService.retrieveAllClients();
        return listClients;
    }

    // http://localhost:8089/menu/client/retrieve-client/8
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    // http://localhost:8089/menu/client/add-client
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c) {
        Client client = clientService.addClient(c);
        return client;
    }

    // http://localhost:8089/menu/client/add-clients
    @PostMapping("/add-clients")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.addClients(clients);
    }

    // http://localhost:8089/menu/client/update-client
    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client c) {
        Client client = clientService.updateClient(c);
        return client;
    }

    // http://localhost:8089/menu/client/remove-client/1
    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.removeClient(clientId);
    }
}
