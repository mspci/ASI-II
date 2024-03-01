package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Commande;
import tn.esprit.tic.ds.springproj.repository.CommandeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {
    private final CommandeRepository commandeRepository;

    @Override
    public List<Commande> findByClientId(Long idClient) {
        return commandeRepository.findByClientIdClient(idClient);
    }

    @Override
    public List<Commande> retrieveByClientIdAndDateCommande(Long idClient, LocalDate dateFrom, LocalDate dateTo) {
        return commandeRepository.findByClientIdClientAndDateCommandeBetween(idClient, dateFrom, dateTo);
    }

    @Override
    public List<Commande> retrieveByClientIdAndDateCommandeOrderByNoteAsc(Long idClient, LocalDate dateFrom, LocalDate dateTo) {
        return commandeRepository.findByClientIdClientAndDateCommandeBetweenOrderByNoteAsc(idClient, dateFrom, dateTo);
    }

    @Override
    public Commande retrieveCommande(Long idCommande) {
        return commandeRepository.findById(idCommande).orElse(null);
    }

    @Override
    public List<Commande> retrieveAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> addCommandes(List<Commande> commandes) {
        return commandeRepository.saveAll(commandes);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void removeCommande(Long idCommande) {
        commandeRepository.deleteById(idCommande);
    }
}
