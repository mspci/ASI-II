package tn.esprit.tic.ds.springproj.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return commandeService.findByClientId(idClient);
    }

    // http://localhost:8089/menu/commande/find-commandes-by-client-and-date/1/2023-01-01/2023-12-31
    @GetMapping("/find-commandes-by-client-and-date/{idClient}/{dateFrom}/{dateTo}")
    public List<Commande> findCommandesByClientAndDate(
            @PathVariable("idClient") Long idClient,
            @PathVariable("dateFrom") String dateFrom,
            @PathVariable("dateTo") String dateTo) {
        LocalDate fromDate = LocalDate.parse(dateFrom);
        LocalDate toDate = LocalDate.parse(dateTo);

        return commandeService.retrieveByClientIdAndDateCommande(idClient, fromDate, toDate);
    }

    // http://localhost:8089/menu/commande/find-commandes-by-client-and-date-ordered-by-note/1/2021-01-01/2021-12-31
    @GetMapping("/find-commandes-by-client-and-date-ordered-by-note/{idClient}/{dateFrom}/{dateTo}")
    public List<Commande> findCommandesByClientAndDateOrderedByNote(
            @PathVariable("idClient") Long idClient,
            @PathVariable("dateFrom") String dateFrom,
            @PathVariable("dateTo") String dateTo) {
        LocalDate fromDate = LocalDate.parse(dateFrom);
        LocalDate toDate = LocalDate.parse(dateTo);

        return commandeService.retrieveByClientIdAndDateCommandeOrderByNoteAsc(idClient, fromDate, toDate);
    }

    // http://localhost:8089/menu/commande/find-commandes/1
    @GetMapping("/find-commandes/{idCommande}")
    public Commande findCommande(@PathVariable("idCommande") Long idCommande) {
        return commandeService.retrieveCommande(idCommande);
    }

    // http://localhost:8089/menu/commande/find-all-commandes
    @GetMapping("/find-all-commandes")
    public List<Commande> findAllCommandes() {
        return commandeService.retrieveAllCommandes();
    }

    // http://localhost:8089/menu/commande/add-commande
    @PostMapping("/add-commande")
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeService.addCommande(commande);
    }

    // http://localhost:8089/menu/commande/add-commandes
    @PostMapping("/add-commandes")
    public List<Commande> addCommandes(@RequestBody List<Commande> commandes) {
        return commandeService.addCommandes(commandes);
    }

    // http://localhost:8089/menu/commande/update-commande
    @PutMapping("/update-commande")
    public Commande updateCommande(@RequestBody Commande commande) {
        return commandeService.updateCommande(commande);
    }

    // http://localhost:8089/menu/commande/remove-commande/1
    @DeleteMapping("/remove-commande/{idCommande}")
    public void removeCommande(@PathVariable("idCommande") Long idCommande) {
        commandeService.removeCommande(idCommande);
    }

    // http://localhost:8089/menu/commande/liste-commandes-par-client/2
    @GetMapping("/liste-commandes-par-client/{identifiant}")
    public List<Commande> listeCommandesParClient(@PathVariable("identifiant") String identifiant) {
        return commandeService.listeCommandesParClient(identifiant);
    }

    @Operation(summary = "Ajouter une commande et l'affecter à un client et un menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Commande ajoutée et affectée à un client et un menu"),
            @ApiResponse(responseCode = "400", description = "Commande non ajoutée ou non affectée à un client ou un menu")
    })
    @PostMapping("/ajouter-commande-et-affecter-a-client-et-menu/{identifiant}/{libelleMenu}")
    public ResponseEntity<?> ajouterCommandeEtAffecterAClientEtMenu(
            @Parameter(description = "Commande à ajouter et affecter à un client et un menu", required = true)
            @RequestBody Commande commande,
            @Parameter(description = "Identifiant du client à affecter à la commande")
            @PathVariable("identifiant") String identifiant,
            @Parameter(description = "Libellé du menu à affecter à la commande")
            @PathVariable("libelleMenu") String libelleMenu) {
        try {
            commandeService.ajouterCommandeEtAffecterAClientEtMenu(commande, identifiant, libelleMenu);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
