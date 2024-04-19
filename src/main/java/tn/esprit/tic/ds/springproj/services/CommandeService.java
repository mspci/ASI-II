package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Client;
import tn.esprit.tic.ds.springproj.entities.Commande;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.repository.ClientRepository;
import tn.esprit.tic.ds.springproj.repository.CommandeRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;

import java.time.LocalDate;
import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    @Override
    @Scheduled(fixedDelay = 10000)
    public void findCurrentYearCommandesOrderByNote() {
        int currentYear = LocalDate.now().getYear();

        commandeRepository.findAll().stream()
                .filter(commande -> commande.getDateCommande().getYear() == currentYear)
                .sorted(Comparator.comparing(Commande::getNote).reversed())
                .forEach((commande) ->
                        log.info("La commande faite le {} d'un montant global de {} a une note de {}",
                                commande.getDateCommande(),
                                commande.getTotalCommande(),
                                commande.getNote())
                );
    }

//    // getYear() deprecated?
//    @Override
//    @Scheduled(fixedDelay = 10000)
//    public void findCurrentYearCommandesOrderByNote() {
//        int currentYear = Year.now().getValue();
//
//        commandeRepository.findAll().stream()
//                .filter(commande -> Year.from(commande.getDateCommande()).equals(Year.of(currentYear)))
//                .sorted(Comparator.comparing(Commande::getNote).reversed())
//                .forEach((commande) ->
//                        log.info("La commande faite le {} d'un montant global de {} a une note de {}",
//                                commande.getDateCommande(),
//                                commande.getTotalCommande(),
//                                commande.getNote())
//                );
//    }

//    @Override
//    @Scheduled(fixedDelay = 10000)
//    public void findCurrentYearCommandesOrderByNote() {
//        // Retrieve the menu with the maximum number of commandes directly from the repository
//        Menu maxMenu = menuRepository.findMenuWithMaxCommandes();
//
//        if (maxMenu != null) {
//            log.info("Le menu le plus commandé dans votre restaurant est {} commandé {} fois",
//                    maxMenu.getIdMenu(),
//                    maxMenu.getCommandes().size());
//        }
//    }

}
