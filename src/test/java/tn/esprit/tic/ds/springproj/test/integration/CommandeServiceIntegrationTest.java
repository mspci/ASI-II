package tn.esprit.tic.ds.springproj.test.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.tic.ds.springproj.entities.Client;
import tn.esprit.tic.ds.springproj.entities.Commande;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.repository.ClientRepository;
import tn.esprit.tic.ds.springproj.repository.CommandeRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;
import tn.esprit.tic.ds.springproj.services.CommandeService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CommandeServiceIntegrationTest {
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void testAjouterCommandeEtAffecterAClientEtMenu() {
        // Given
        Commande commande = new Commande();
        commande.setPourcentageRemise(10);
        String identifiant = "Amira Boujelben";
        String libelleMenu = "Menu A";

        // When
        commandeService.ajouterCommandeEtAffecterAClientEtMenu(commande, identifiant, libelleMenu);

        // Then
        assertNotNull(commandeRepository.findById(commande.getIdCommande()));
    }
}
