package tn.esprit.tic.ds.springproj.test.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tic.ds.springproj.entities.Client;
import tn.esprit.tic.ds.springproj.entities.Commande;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.repository.ClientRepository;
import tn.esprit.tic.ds.springproj.repository.CommandeRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;
import tn.esprit.tic.ds.springproj.services.CommandeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommandeServiceTest {

    @Mock
    private CommandeRepository commandeRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private CommandeService commandeService;

    @Test
    public void testFindByClientId() {
        // Given
        Long idClient = 1L;
        List<Commande> expectedCommandes = new ArrayList<>();
        when(commandeRepository.findByClientIdClient(idClient)).thenReturn(expectedCommandes);

        // When
        List<Commande> actualCommandes = commandeService.findByClientId(idClient);

        // Then
        assertEquals(expectedCommandes, actualCommandes);
        verify(commandeRepository, times(1)).findByClientIdClient(idClient);
    }

    @Test
    public void testRetrieveByClientIdAndDateCommande() {
        // Given
        Long idClient = 1L;
        LocalDate dateFrom = LocalDate.of(2023, 1, 1);
        LocalDate dateTo = LocalDate.of(2023, 12, 31);
        List<Commande> expectedCommandes = new ArrayList<>();
        when(commandeRepository.findByClientIdClientAndDateCommandeBetween(idClient, dateFrom, dateTo)).thenReturn(expectedCommandes);

        // When
        List<Commande> actualCommandes = commandeService.retrieveByClientIdAndDateCommande(idClient, dateFrom, dateTo);

        // Then
        assertEquals(expectedCommandes, actualCommandes);
        verify(commandeRepository, times(1)).findByClientIdClientAndDateCommandeBetween(idClient, dateFrom, dateTo);
    }

    @Test
    public void testRetrieveByClientIdAndDateCommandeOrderByNoteAsc() {
        // Given
        Long idClient = 1L;
        LocalDate dateFrom = LocalDate.of(2023, 1, 1);
        LocalDate dateTo = LocalDate.of(2023, 12, 31);
        List<Commande> expectedCommandes = new ArrayList<>();
        when(commandeRepository.findByClientIdClientAndDateCommandeBetweenOrderByNoteAsc(idClient, dateFrom, dateTo)).thenReturn(expectedCommandes);

        // When
        List<Commande> actualCommandes = commandeService.retrieveByClientIdAndDateCommandeOrderByNoteAsc(idClient, dateFrom, dateTo);

        // Then
        assertEquals(expectedCommandes, actualCommandes);
        verify(commandeRepository, times(1)).findByClientIdClientAndDateCommandeBetweenOrderByNoteAsc(idClient, dateFrom, dateTo);
    }

    @Test
    public void testRetrieveCommande() {
        // Given
        Long idCommande = 1L;
        Commande expectedCommande = new Commande();
        when(commandeRepository.findById(idCommande)).thenReturn(Optional.of(expectedCommande));

        // When
        Commande actualCommande = commandeService.retrieveCommande(idCommande);

        // Then
        assertEquals(expectedCommande, actualCommande);
        verify(commandeRepository, times(1)).findById(idCommande);
    }

    @Test
    public void testRetrieveAllCommandes() {
        // Given
        List<Commande> expectedCommandes = new ArrayList<>();
        when(commandeRepository.findAll()).thenReturn(expectedCommandes);

        // When
        List<Commande> actualCommandes = commandeService.retrieveAllCommandes();

        // Then
        assertEquals(expectedCommandes, actualCommandes);
        verify(commandeRepository, times(1)).findAll();
    }

    @Test
    public void testAddCommande() {
        // Given
        Commande commande = new Commande();
        when(commandeRepository.save(commande)).thenReturn(commande);

        // When
        Commande actualCommande = commandeService.addCommande(commande);

        // Then
        assertEquals(commande, actualCommande);
        verify(commandeRepository, times(1)).save(commande);
    }

    @Test
    public void testAddCommandes() {
        // Given
        List<Commande> commandes = new ArrayList<>();
        when(commandeRepository.saveAll(commandes)).thenReturn(commandes);

        // When
        List<Commande> actualCommandes = commandeService.addCommandes(commandes);

        // Then
        assertEquals(commandes, actualCommandes);
        verify(commandeRepository, times(1)).saveAll(commandes);
    }

    @Test
    public void testUpdateCommande() {
        // Given
        Commande commande = new Commande();
        when(commandeRepository.save(commande)).thenReturn(commande);

        // When
        Commande actualCommande = commandeService.updateCommande(commande);

        // Then
        assertEquals(commande, actualCommande);
        verify(commandeRepository, times(1)).save(commande);
    }

    @Test
    public void testRemoveCommande() {
        // Given
        Long idCommande = 1L;

        // When
        commandeService.removeCommande(idCommande);

        // Then
        verify(commandeRepository, times(1)).deleteById(idCommande);
    }

    @Test
    public void testListeCommandesParClient() {
        // Given
        String identifiant = "client1";
        List<Commande> expectedCommandes = new ArrayList<>();
        when(commandeRepository.findByClientIdentifiant(identifiant)).thenReturn(expectedCommandes);

        // When
        List<Commande> actualCommandes = commandeService.listeCommandesParClient(identifiant);

        // Then
        assertEquals(expectedCommandes, actualCommandes);
        verify(commandeRepository, times(1)).findByClientIdentifiant(identifiant);
    }

    @Test
    public void testAjouterCommandeEtAffecterAClientEtMenu() {
        // Given
        Commande commande = new Commande();
        commande.setPourcentageRemise(10);
        String identifiant = "client1";
        String libelleMenu = "Menu A";
        Client client = new Client();
        Menu menu = new Menu();
        when(clientRepository.findByIdentifiant(identifiant)).thenReturn(Optional.of(client));
        when(menuRepository.findByLibelleMenu(libelleMenu)).thenReturn(Optional.of(menu));

        // When
        commandeService.ajouterCommandeEtAffecterAClientEtMenu(commande, identifiant, libelleMenu);

        // Then
        assertEquals(client, commande.getClient());
        assertEquals(menu, commande.getMenu());
        assertNotNull(commande.getTotalRemise());
        assertNotNull(commande.getTotalCommande());
        verify(commandeRepository, times(1)).save(commande);
    }
}
