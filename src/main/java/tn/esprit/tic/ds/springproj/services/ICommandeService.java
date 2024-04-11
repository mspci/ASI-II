package tn.esprit.tic.ds.springproj.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Commande;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ICommandeService {
    List<Commande> findByClientId(Long idClient);

    List<Commande> retrieveByClientIdAndDateCommande(Long idClient, LocalDate dateFrom, LocalDate dateTo);

    List<Commande> retrieveByClientIdAndDateCommandeOrderByNoteAsc(Long idClient, LocalDate dateFrom, LocalDate dateTo);

    Commande retrieveCommande(Long idCommande);

    List<Commande> retrieveAllCommandes();

    Commande addCommande(Commande commande);

    List<Commande> addCommandes(List<Commande> commandes);

    Commande updateCommande(Commande commande);

    void removeCommande(Long idCommande);

    List<Commande> listeCommandesParClient(String identifiant);

    void ajouterCommandeEtAffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu);
}
