package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ds.springproj.entities.Commande;
import tn.esprit.tic.ds.springproj.services.ICommandeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/commande")
public class CommandeController {
    private final ICommandeService commandeService;

    // http://localhost:8089/menu/commande/find-commandes-by-client/1
    @GetMapping("/find-commandes-by-client/{idClient}")
    public List<Commande> findCommandesByClient(@PathVariable("idClient") Long idClient) {
        List<Commande> commandes = commandeService.findByClientId(idClient);
        return commandes;
    }

    // http://localhost:8089/menu/commande/find-commandes-by-client-and-date/1/2023-01-01/2023-12-31
    @GetMapping("/find-commandes-by-client-and-date/{idClient}/{dateFrom}/{dateTo}")
    public List<Commande> findCommandesByClientAndDate(
            @PathVariable("idClient") Long idClient,
            @PathVariable("dateFrom") String dateFrom,
            @PathVariable("dateTo") String dateTo) {
        LocalDate fromDate = LocalDate.parse(dateFrom);
        LocalDate toDate = LocalDate.parse(dateTo);

        List<Commande> commandes = commandeService.retrieveByClientIdAndDateCommande(
                idClient, fromDate, toDate);
        return commandes;
    }

    // http://localhost:8089/menu/commande/find-commandes-by-client-and-date-ordered-by-note/1/2021-01-01/2021-12-31
    @GetMapping("/find-commandes-by-client-and-date-ordered-by-note/{idClient}/{dateFrom}/{dateTo}")
    public List<Commande> findCommandesByClientAndDateOrderedByNote(
            @PathVariable("idClient") Long idClient,
            @PathVariable("dateFrom") String dateFrom,
            @PathVariable("dateTo") String dateTo) {
        LocalDate fromDate = LocalDate.parse(dateFrom);
        LocalDate toDate = LocalDate.parse(dateTo);

        List<Commande> commandes = commandeService.retrieveByClientIdAndDateCommandeOrderByNoteAsc(
                idClient, fromDate, toDate);
        return commandes;
    }

    // http://localhost:8089/menu/commande/find-commandes/1
    @GetMapping("/find-commandes/{idCommande}")
    public Commande findCommande(@PathVariable("idCommande") Long idCommande) {
        Commande commande = commandeService.retrieveCommande(idCommande);
        return commande;
    }

    // http://localhost:8089/menu/commande/find-all-commandes
    @GetMapping("/find-all-commandes")
    public List<Commande> findAllCommandes() {
        List<Commande> commandes = commandeService.retrieveAllCommandes();
        return commandes;
    }

    // http://localhost:8089/menu/commande/add-commande
    @PostMapping("/add-commande")
    public Commande addCommande(@RequestBody Commande commande) {
        Commande addedCommande = commandeService.addCommande(commande);
        return addedCommande;
    }

    // http://localhost:8089/menu/commande/add-commandes
    @PostMapping("/add-commandes")
    public List<Commande> addCommandes(@RequestBody List<Commande> commandes) {
        List<Commande> addedCommandes = commandeService.addCommandes(commandes);
        return addedCommandes;
    }

    // http://localhost:8089/menu/commande/update-commande
    @PutMapping("/update-commande")
    public Commande updateCommande(@RequestBody Commande commande) {
        Commande updatedCommande = commandeService.updateCommande(commande);
        return updatedCommande;
    }

    // http://localhost:8089/menu/commande/remove-commande/1
    @DeleteMapping("/remove-commande/{idCommande}")
    public void removeCommande(@PathVariable("idCommande") Long idCommande) {
        commandeService.removeCommande(idCommande);
    }
}
