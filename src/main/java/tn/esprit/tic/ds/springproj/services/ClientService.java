package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Client;
import tn.esprit.tic.ds.springproj.entities.Commande;
import tn.esprit.tic.ds.springproj.repository.ClientRepository;
import tn.esprit.tic.ds.springproj.repository.CommandeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    @Override
    public List<Client> retrieveAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client addClient(Client e) {
        return clientRepository.save(e);
    }

    @Override
    public List<Client> addClients(List<Client> Clients) {
        return (List<Client>) clientRepository.saveAll(Clients);
    }

    @Override
    public Client updateClient(Client e) {
        return clientRepository.save(e);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public Float montantDepenseParClientEntreDeuxDates(String identifiant, LocalDate date1, LocalDate date2) {
        List<Commande> commandes = commandeRepository.findByClient_IdentifiantAndDateCommandeBetween(identifiant, date1, date2);
        return commandes.stream().map(Commande::getTotalCommande).reduce(0f, Float::sum);
    }
}
