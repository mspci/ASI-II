package tn.esprit.tic.ds.springproj.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Client;

import java.util.List;

@Service
public interface IClientService {
    Client retrieveClient(Long idClient);

    List<Client> retrieveAllClients();

    Client addClient(Client e);

    List<Client> addClients(List<Client> Clients);

    Client updateClient(Client e);

    void removeClient(Long idClient);
}
