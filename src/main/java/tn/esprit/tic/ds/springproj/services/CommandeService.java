package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Client;
import tn.esprit.tic.ds.springproj.entities.Commande;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.repository.ClientRepository;
import tn.esprit.tic.ds.springproj.repository.CommandeRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final MenuRepository menuRepository;

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

    @Override
    public List<Commande> listeCommandesParClient(String identifiant) {
        return commandeRepository.findByClientIdentifiant(identifiant);
    }

    @Override
    public void ajouterCommandeEtAffecterAClientEtMenu(Commande commande,
                                                       String identifiant,
                                                       String libelleMenu) {
        Client client = clientRepository.findByIdentifiant(identifiant)
                .orElseThrow(() -> new IllegalArgumentException("Client not found."));

        Menu menu = menuRepository.findByLibelleMenu(libelleMenu)
                .orElseThrow(() -> new IllegalArgumentException("Menu not found."));

        commande.setClient(client);
        commande.setMenu(menu);

        Float prixTotal = menu.getPrixTotal() == null ? 0f : menu.getPrixTotal();
        Float totalRemise = prixTotal * commande.getPourcentageRemise() / 100;
        Float totalCommande = prixTotal - totalRemise;

        commande.setTotalRemise(totalRemise);
        commande.setTotalCommande(totalCommande);

        commandeRepository.save(commande);
    }
}
